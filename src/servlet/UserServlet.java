package servlet;

import com.sun.deploy.net.HttpRequest;
import dao.EmpDAO;
import dao.EmpDAOImpl;
import pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class UserServlet extends BaseServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null) {
            request.setAttribute("error", "登录信息有误！请重试");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        } else {
            EmpDAO empDAO = new EmpDAOImpl();
            Emp emp = null;
            try {
                emp = empDAO.findByName(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (emp != null && emp.getEmpno() != -1 && emp.getEpass().equals(password)) {
                //cookie
                String rememberme = request.getParameter("rememberme");
                //remember me
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);
                if (rememberme != null) {
                    cookie1.setMaxAge(60 * 60 * 24 * 10);
                    cookie2.setMaxAge(60 * 60 * 24 * 10);
                } else {
                    //cancel
                    cookie1.setMaxAge(0);
                    cookie2.setMaxAge(0);
                }
                cookie1.setPath("/");
                cookie2.setPath("/");
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                request.getSession().setAttribute("user", emp);
                request.getRequestDispatcher("index.jsp")
                        .forward(request, response);
                return;
            }
        }
        request.setAttribute("error", "账号或密码错误");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    //用户注销
    public void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            //end session
            request.getSession().invalidate();
            //jump to login
            response.sendRedirect("/ManagementSystem/login.jsp");
        }
    }
}
