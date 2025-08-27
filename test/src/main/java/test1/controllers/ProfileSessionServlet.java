package test1.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profileSession")
public class ProfileSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("name") != null) {
            String name = (String) session.getAttribute("name");
            out.println("Chào bạn, " + name + " đến với Profile (Session)<br/>");
            out.println("<a href='logoutSession'>Logout</a>");
        } else {
            out.println("Bạn chưa đăng nhập!<br/>");
            resp.sendRedirect("login-session.html");
        }
    }
}
