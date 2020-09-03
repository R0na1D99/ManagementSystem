package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.DeptDaoImpl;
import com.neuedu.pojo.Dept;
import com.neuedu.util.DBUtils;

@WebServlet("/DeptUpdateController")
public class DeptUpdateController extends HttpServlet {		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d_no=request.getParameter("deptNo");
        String dname=request.getParameter("dName");
        String dtel=request.getParameter("dTel");
        String dbirth=request.getParameter("dBirth");
        if(d_no!=null&&dbirth!=null){       	
            Dept dept=new Dept();
            dept.setdName(dname);
            dept.setDeptNo((int)Integer.valueOf(d_no));
            dept.setdBirth(DBUtils.getDate(dbirth));
            dept.setdTel(dtel);
            DeptDaoImpl deptDao = new DeptDaoImpl();
            deptDao.updateDept(dept);
            request.setAttribute("error","信息修改成功");
            request.getRequestDispatcher("DeptListController").forward(request,response);
        }else{
            request.setAttribute("error","修改信息有误");
            request.getRequestDispatcher("DeptListController").forward(request,response);
        }				
	}

}
