package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.DeptDaoImpl;
import com.neuedu.pojo.Dept;


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDaoImpl deptDAO = new DeptDaoImpl();
        String d_no = request.getParameter("deptNo");
        if(d_no!=null){
        	Dept dept = new Dept();
        	dept=deptDAO.selectDeptByID((int)Integer.valueOf(d_no));
            request.setAttribute("dept",dept);
            request.getRequestDispatcher("Department/modifyDept.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("Department/deptManage.jsp").forward(request,response);
        }
		
	}

}
