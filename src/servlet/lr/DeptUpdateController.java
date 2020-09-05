package servlet.lr;

import dao.DeptDaoImpl;
import pojo.Dept;
import utils.DBUtils;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeptUpdateController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d_no = request.getParameter("deptNo");
        String dname = new String(request.getParameter("dName").getBytes("iso-8859-1"), "utf-8");
        String dtel = request.getParameter("dTel");
        String dbirth = request.getParameter("dBirth");
        String dType = new String(request.getParameter("dType").getBytes("iso-8859-1"), "utf-8");
        if (d_no != null && dbirth != null) {
            Dept dept = new Dept();
            dept.setdName(dname);
            dept.setDeptNo((int) Integer.valueOf(d_no));
            dept.setdBirth(DBUtils.getDate(dbirth));
            dept.setdTel(dtel);
            dept.setdType(dType);
            DeptDaoImpl deptDao = new DeptDaoImpl();
            try {
                deptDao.updateDept(dept);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.setAttribute("error", "信息修改成功");
            request.getRequestDispatcher("Dept/deptManage.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "修改信息有误");
            request.getRequestDispatcher("Dept/modifyDept").forward(request, response);
        }
    }

}
