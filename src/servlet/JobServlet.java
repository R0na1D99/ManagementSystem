package servlet;

import dao.JobDAO;
import dao.JobDAOImpl;
import pojo.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
                request.getRequestDispatcher("Jobs/addJob.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("error", "登录信息有误");
            request.getRequestDispatcher("Jobs/addJob.jsp").forward(request, response);
        }
    }
}
