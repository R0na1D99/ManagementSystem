package servlet.lr;

import dao.DeptDaoImpl;
import pojo.Dept;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDaoImpl deptDAO = new DeptDaoImpl();
		String d_no = request.getParameter("deptNo");
		if (d_no != null) {
			Dept dept = new Dept();
			try {
				dept = deptDAO.selectDeptByID((int) Integer.valueOf(d_no));
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			request.setAttribute("dept", dept);
			request.getRequestDispatcher("Dept/modifyDept.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("Dept/deptManage.jsp").forward(request, response);
		}

	}

}
