package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.DeptDaoImpl;
import com.neuedu.pojo.Dept;
import com.neuedu.util.DBUtils;


@WebServlet("/DeptInsertController")
public class DeptInsertController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		DeptDaoImpl deptDao=new DeptDaoImpl();
		//发送数据到页面
		String dname=request.getParameter("dName");
		Date dBirth=DBUtils.getDate(request.getParameter("dBirth"));
		String dTel=request.getParameter("dTel");
		int deptNo=Integer.parseInt(request.getParameter("DeptNo"));

        if(!String.valueOf(deptNo).equals("")&&dname!=null){
    		Dept dept=deptDao.selectDept(dname);
            if(dept.getDeptNo()!=-1){
                request.setAttribute("error", "部门已存在");
                request.getRequestDispatcher("addDept.jsp").forward(request, response);
            }else{
            	dept.setDeptNo(deptNo);
            	dept.setdName(dname);
            	dept.setdBirth(dBirth);
            	dept.setdTel(dTel);
                deptDao.insertDept(dept);
                request.setAttribute("error", "添加成功");
                request.getRequestDispatcher("addDept.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("error", "登录信息有误");
            request.getRequestDispatcher("addDept.jsp").forward(request, response);
        }
	}
}
