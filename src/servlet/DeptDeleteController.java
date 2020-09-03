package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.DeptDaoImpl;
import com.neuedu.pojo.Dept;

@WebServlet("/DeptDeleteController")
public class DeptDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDaoImpl dao = new DeptDaoImpl();
		//获取请求参数
		String deptNo=request.getParameter("deptNo");
		int i=dao.deleteDept(Integer.parseInt(deptNo));
		if(i>0) {
			request.getRequestDispatcher("DeptListController").forward(request, response);
		}
//		
	}

}
