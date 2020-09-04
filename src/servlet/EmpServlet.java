package servlet;

import dao.EmpDAO;
import dao.EmpDAOImpl;
import pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpServlet extends BaseServlet {
    public void quit(HttpServletRequest request, HttpServletResponse response) throws Exception{
        int empno = Integer.valueOf(request.getParameter("empno"));
        if(!String.valueOf(empno).equals("")){
            EmpDAO empDao = new EmpDAOImpl();
            Emp emp = empDao.findByNo(empno);
            if(emp.getEmpno()==-1){
                request.setAttribute("error", "员工ID不存在");
            }else{
                if (request.getParameter("way").equals("retire")) {
                    emp.setEtype(0);//0代表退休
                } else if (request.getParameter("way").equals("dismiss")) {
                    emp.setEtype(3);//3代表辞退
                } else if (request.getParameter("way").equals("fire")) {
                    emp.setEtype(4);//4代表开除
                } else if (request.getParameter("way").equals("resign")) {
                    emp.setEtype(5);//5代表主动辞职
                }
                java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

                empDao.update(emp);
                request.setAttribute("error", "操作成功");
                request.getRequestDispatcher("Emps/deleteEmp.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "信息有误");
            request.getRequestDispatcher("Emps/deleteEmp.jsp").forward(request, response);
        }
    }

    public void eClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int empno = Integer.valueOf(request.getParameter("empno"));
        if (!String.valueOf(empno).equals("")) {
            EmpDAO empDao = new EmpDAOImpl();
            Emp emp = empDao.findByNo(empno);
            if (emp.getEmpno() == -1) {
                request.setAttribute("error", "员工ID不存在");
            } else {
                if (request.getParameter("type").equals("yes")) {
                    emp.setEstore("是");
                } else if (request.getParameter("type").equals("no")) {
                    emp.setEstore("否");
                }
                empDao.update(emp);
                request.setAttribute("error", "操作成功");
                request.getRequestDispatcher("Emps/deleteEmp.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "信息有误");
            request.getRequestDispatcher("Emps/deleteEmp.jsp").forward(request, response);
        }
    }

}
