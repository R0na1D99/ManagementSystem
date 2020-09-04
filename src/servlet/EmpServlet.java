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

@WebServlet(name = "EmpServlet")
public class EmpServlet extends BaseServlet {
    public void quit(HttpServletRequest request, HttpServletResponse response) throws Exception{

        int empno = Integer.valueOf(request.getParameter("empno"));
        if(!String.valueOf(empno).equals("")){
            EmpDAO empDao = new EmpDAOImpl();
            Emp emp = empDao.findByNo(empno);
            if(emp.getEmpno()==-1){
                request.setAttribute("error", "员工ID不存在");
            }else{
                if(request.getParameter("way").equals("retire")){
                    emp.setEtype(0);//0代表退休
                }else if(request.getPart("way").equals("dismiss")){
                    emp.setEtype(1);//1代表辞退
                }else if(request.getParameter("way").equals("fire")){
                    emp.setEtype(2);//2代表开除
                }else if(request.getParameter("way").equals("resign")){
                    emp.setEtype(3);//3代表主动辞职
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
                String s = sdf.format(new Date());
                emp.setEbirth(java.sql.Date.valueOf(s));//记录离职日期
                empDao.update(emp);
                request.setAttribute("error", "操作成功");
            }
        }
    }
}
