package servlet.lr;

import dao.DeptDaoImpl;
import pojo.Dept;
import utils.DBUtils;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeptInsertController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptNo = (int) Integer.parseInt(request.getParameter("deptNo"));
		//从页面获取数据
		String dname = new String(request.getParameter("dName").getBytes("iso-8859-1"), "utf-8");
		String dBirth = request.getParameter("dBirth");
		String dTel = request.getParameter("dTel");
		String dType = new String(request.getParameter("dType").getBytes("iso-8859-1"), "utf-8");
		if (dname != null) {
			DeptDaoImpl deptDao = new DeptDaoImpl();
			Dept dept = null;
			try {
				dept = deptDao.selectDeptByID(deptNo);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if (dept.getDeptNo() != -1) {
				request.setAttribute("error", "部门已存在");
				request.getRequestDispatcher("Dept/addDept.jsp").forward(request, response);
			} else {
				dept.setDeptNo(deptNo);
				dept.setdName(dname);
				dept.setdBirth(DBUtils.getDate(dBirth));
				dept.setdTel(dTel);
				dept.setdType(dType);
				try {
					deptDao.insertDept(dept);
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("error", "添加成功");
				request.getRequestDispatcher("Dept/addDept.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", "登录信息有误");
			request.getRequestDispatcher("Dept/addDept.jsp").forward(request, response);
		}
	}
}
