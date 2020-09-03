package servlet;

import dao.EmpDAO;
import dao.EmpDAOImpl;
import dao.JobDAO;
import dao.JobDAOImpl;
import pojo.Emp;
import pojo.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobServlet extends BaseServlet {
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int jobno = Integer.valueOf(request.getParameter("jobno"));
        String jname = request.getParameter("jname");
        String jtype = request.getParameter("jtype");
        if(!String.valueOf(jobno).equals("")&&jname!=null&&jtype!=null){
            JobDAO jobDAO=new JobDAOImpl();
            Job job=jobDAO.findByNo(jobno);
            if(job.getJobno()!=-1){
                request.setAttribute("error", "岗位ID已存在");
                request.getRequestDispatcher("Jobs/addJob.jsp").forward(request, response);
            }else{
                job.setJobno(jobno);
                job.setJname(jname);
                job.setJtype(jtype);
                jobDAO.insert(job);
                request.setAttribute("error", "添加成功");
                request.getRequestDispatcher("Jobs/modify.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("error", "信息有误");
            request.getRequestDispatcher("Jobs/addJob.jsp").forward(request, response);
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int jobno = Integer.valueOf(request.getParameter("jobno"));
        if(!String.valueOf(jobno).equals("")){
            JobDAO jobDAO=new JobDAOImpl();
            jobDAO.delete(jobno);
            response.sendRedirect("/ManagementSystem/Jobs/modify.jsp");
        }else{
            response.sendRedirect("/ManagementSystem/Jobs/modify.jsp");
        }
    }
    public void modify(HttpServletRequest request, HttpServletResponse response) throws Exception{
        JobDAOImpl jobDAO = new JobDAOImpl();
        String s_no = request.getParameter("jobno");
        if(s_no!=null){
            Job job = jobDAO.findByNo(Integer.valueOf(s_no));
            request.setAttribute("job",job);
            request.getRequestDispatcher("Jobs/modifyJob.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("Jobs/modify.jsp").forward(request,response);
        }
    }
    public void modifyJob(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String s_jobno=request.getParameter("jobno");
        String jname=request.getParameter("jname");
        String jtype=request.getParameter("jtype");
        if(s_jobno!=null&&jname!=null&&jtype!=null&&!s_jobno.equals("")&&!s_jobno.equals("-1")&&!jname.equals("")&&!jtype.equals("")){
            Job job=new Job();
            job.setJobno(Integer.valueOf(s_jobno));
            job.setJname(jname);
            job.setJtype(jtype);
            JobDAO jobDAO=new JobDAOImpl();
            jobDAO.update(job);
            request.setAttribute("error","信息修改成功");
            request.getRequestDispatcher("Jobs/modify.jsp").forward(request,response);
        }else{
            request.setAttribute("error","修改信息有误");
            request.getRequestDispatcher("Jobs/modify.jsp").forward(request,response);
        }
    }
    public void showEmp(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String s_jobno=request.getParameter("jobno");
        if(s_jobno!=null){
            EmpDAO empDAO=new EmpDAOImpl();
            List<Emp> emps=new ArrayList<Emp>();
            //findByJobno
            request.setAttribute("list",emps);
            request.getRequestDispatcher("Jobs/showEmps.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("Jobs/modify.jsp").forward(request,response);
        }
    }
}
