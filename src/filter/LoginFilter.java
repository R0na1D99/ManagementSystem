package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        URL url = new URL(req.getRequestURL().toString());
        String str = url.getPath();
        str = str.substring(str.lastIndexOf('/') + 1);
        HttpSession session = req.getSession();
        if (!str.equals("") &&
                !str.contains("UserServlet") &&
                !str.contains(".css") &&
                !(str.contains(".js") && !str.contains(".jsp")) &&
                !str.contains("login.jsp") &&
                session.getAttribute("user") == null) {
            req.setAttribute("error", "请先登录！");
            req.getRequestDispatcher("").forward(req, res);
        } else chain.doFilter(req, res);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
