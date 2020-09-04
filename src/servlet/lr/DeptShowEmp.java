package servlet.lr;

import dao.DeptDaoImpl;
import pojo.Emp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeptShowEmp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptDaoImpl dao = new DeptDaoImpl();
        String deptNo = request.getParameter("deptNo");
        List<Emp> empList = null;
        try {
            empList = dao.findByDept(Integer.parseInt(deptNo));
        } catch (Exception e) {
            e.printStackTrace();
        }
//		发送数据至页面
        request.setAttribute("list", empList);
//		跳转页面
        request.getRequestDispatcher("Dept/empInDept.jsp").forward(request, response);
    }

}
