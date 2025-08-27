package test1.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginSession")
public class LoginSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("loinguyen".equals(username) && "123".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("name", username);

            out.println("Chào mừng, " + username);
            out.println("<br/><a href='profileSession'>Vào Profile</a>");
            out.println("<br/><a href='logoutSession'>Logout</a>");
        } else {
            out.println("Sai tài khoản hoặc mật khẩu!<br/>");
            req.getRequestDispatcher("login-session.html").include(req, resp);
        }
    }
}
