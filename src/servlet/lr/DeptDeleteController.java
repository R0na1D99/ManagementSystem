package servlet.lr;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDaoImpl;
import pojo.Emp;

public class DeptDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDaoImpl dao = new DeptDaoImpl();
		//获取请求参数
		String deptNo = request.getParameter("deptNo");
		List<Emp> empList = null;
		try {
			empList = dao.findByDept((int) Integer.parseInt(deptNo));
			if (empList.size() == 0) {
				int i = dao.deleteDept(Integer.parseInt(deptNo));
				if (i > 0) {
                    request.getRequestDispatcher("Dept/deptManage.jsp").forward(request, response);
                }
			} else {
                request.setAttribute("error", "删除失败，该部门下已有员工");
                request.getRequestDispatcher("Dept/deptManage.jsp").forward(request, response);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

//		
	}

}
