package servlet;

import dao.EmpDAO;
import dao.EmpDAOImpl;
import dao.JobDAO;
import dao.JobDAOImpl;
import pojo.Emp;
import pojo.Job;
import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class EmpServlet extends BaseServlet {
    public void quit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int empno = Integer.valueOf(request.getParameter("empno"));
        if (!String.valueOf(empno).equals("")) {
            EmpDAO empDao = new EmpDAOImpl();
            Emp emp = empDao.findByNo(empno);
            if (emp.getEmpno() == -1) {
                request.setAttribute("error", "员工ID不存在");
            } else {
                if (request.getParameter("way").equals("retire")) {
                    emp.setEtype(0);//0代表退休
                } else if (request.getParameter("way").equals("dismiss")) {
                    emp.setEtype(3);//3代表辞退
                } else if (request.getParameter("way").equals("fire")) {
                    emp.setEtype(4);//4代表开除
                } else if (request.getParameter("way").equals("resign")) {
                    emp.setEtype(5);//5代表主动辞职
                }
                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

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

    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ename = request.getParameter("ename");
        String empno = request.getParameter("jobno");
        String epass = request.getParameter("epass");
        String deptno = request.getParameter("jname");
        String esex = request.getParameter("esex");
        String ebirth = request.getParameter("ebirth");
        String eidnum = request.getParameter("eidnum");
        String jobno = request.getParameter("jtype");
        String ehiredate = request.getParameter("ehiredate");
        String etype = request.getParameter("etype");
        String esource = request.getParameter("esource");
        String estore = "否";

        if (new EmpDAOImpl().findByNo(Integer.valueOf(empno)).getEmpno() == -1 && new EmpDAOImpl().findByName(ename).getEmpno() == -1) {
            if (empno != null && deptno != null && jobno != null) {
                Emp emp = new Emp();
                emp.setEname(ename);
                emp.setEbirth(DBUtils.getDate(ebirth));
                emp.setEidnum(eidnum);
                emp.setEpass(epass);
                emp.setJobno(Integer.valueOf(jobno));
                emp.setEmpno(Integer.valueOf(empno));
                emp.setEsex(Integer.valueOf(esex));
                emp.setEtype(Integer.valueOf(etype));
                emp.setDeptno(Integer.valueOf(deptno));
                emp.setEsource(Integer.valueOf(esource));
                emp.setEhiredate(DBUtils.getDate(ehiredate));
                emp.setEstore(estore);
                EmpDAO empDAO = new EmpDAOImpl();
                empDAO.insert(emp);
                request.setAttribute("error", "信息添加成功");
                request.getRequestDispatcher("Entry/TalentPool.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "信息有误");
                request.getRequestDispatcher("Entry/addEmp.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "存在重复信息！");
            request.getRequestDispatcher("Entry/addEmp.jsp").forward(request, response);
        }

    }

    public void addOld(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ename = request.getParameter("ename");
        String empno = request.getParameter("jobno");
        String epass = request.getParameter("epass");
        String deptno = request.getParameter("jname");
        String esex = request.getParameter("esex");
        String ebirth = request.getParameter("ebirth");
        String eidnum = request.getParameter("eidnum");
        String jobno = request.getParameter("jtype");
        String ehiredate = request.getParameter("ehiredate");
        String etype = request.getParameter("etype");
        String esource = request.getParameter("esource");
        String estore = "否";

        if (empno != null && deptno != null && jobno != null) {
            Emp emp = new Emp();
            emp.setEname(ename);
            emp.setEbirth(DBUtils.getDate(ebirth));
            emp.setEidnum(eidnum);
            emp.setEpass(epass);
            emp.setJobno(Integer.valueOf(jobno));
            emp.setEmpno(Integer.valueOf(empno));
            emp.setEsex(Integer.valueOf(esex));
            emp.setEtype(Integer.valueOf(etype));
            emp.setDeptno(Integer.valueOf(deptno));
            emp.setEsource(Integer.valueOf(esource));
            emp.setEhiredate(DBUtils.getDate(ehiredate));
            emp.setEstore(estore);
            EmpDAO empDAO = new EmpDAOImpl();
            empDAO.update(emp);
            request.setAttribute("error", "信息添加成功");
            request.getRequestDispatcher("Entry/TalentPool.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "信息有误");
            request.getRequestDispatcher("Entry/addEmp.jsp").forward(request, response);
        }

    }

    public void modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        EmpDAOImpl empDAO = new EmpDAOImpl();
        String s_no = request.getParameter("empno");
        if (s_no != null) {
            Emp emp = empDAO.findByNo(Integer.valueOf(s_no));
            request.setAttribute("emp", emp);
            request.getRequestDispatcher("Entry/Emodify.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Entry/TalentPool.jsp").forward(request, response);
        }
    }

    public void Emodify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ename = request.getParameter("ename");
        String empno = request.getParameter("jobno");
        String epass = request.getParameter("epass");
        String deptno = request.getParameter("jname");
        String esex = request.getParameter("esex");
        String ebirth = request.getParameter("ebirth");
        String eidnum = request.getParameter("eidnum");
        String jobno = request.getParameter("jtype");
        String ehiredate = request.getParameter("ehiredate");
        String etype = String.valueOf(new EmpDAOImpl().findByNo(Integer.valueOf(empno)).getEtype());
        String esource = request.getParameter("esource");
        String estore = request.getParameter("estore");

        if (empno != null && deptno != null && jobno != null) {
            Emp emp = new Emp();
            emp.setEname(ename);
            emp.setEbirth(DBUtils.getDate(ebirth));
            emp.setEidnum(eidnum);
            emp.setEpass(epass);
            emp.setJobno(Integer.valueOf(jobno));
            emp.setEmpno(Integer.valueOf(empno));
            emp.setEsex(Integer.valueOf(esex));
            emp.setEtype(Integer.valueOf(etype));
            emp.setDeptno(Integer.valueOf(deptno));
            emp.setEsource(Integer.valueOf(esource));
            emp.setEhiredate(DBUtils.getDate(ehiredate));
            emp.setEstore(estore);
            EmpDAO empDAO = new EmpDAOImpl();
            empDAO.update(emp);
            request.setAttribute("error", "信息修改成功");
            request.getRequestDispatcher("Entry/TalentPool.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "修改信息有误");
            request.getRequestDispatcher("Entry/TalentPool.jsp").forward(request, response);
        }
    }

    public void addTalent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        EmpDAOImpl empDAO = new EmpDAOImpl();
        String s_no = request.getParameter("empno");
        if (s_no != null) {
            Emp emp = empDAO.findByNo(Integer.valueOf(s_no));
            request.setAttribute("emp", emp);
            request.getRequestDispatcher("Entry/addTalent.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Entry/TalentPool.jsp").forward(request, response);
        }
    }
}
