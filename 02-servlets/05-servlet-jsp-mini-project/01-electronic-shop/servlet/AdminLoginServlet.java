package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/alog")
public class AdminLoginServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");

        // ✅ Case 1: Empty username/password
        if (uname == null || upwd == null || uname.trim().isEmpty() || upwd.trim().isEmpty()) {
            out.println("<h1 style='color:red; text-align:center;'>⚠️ Please enter both username and password!</h1>");
            req.getRequestDispatcher("AdminLogin.html").include(req, resp);
            return;
        }

        // ✅ Case 2: Check login credentials
        AdminBean abean = new AdminLoginDAO().checkAdminLogin(uname.trim(), upwd.trim());

        if (abean == null) {
            out.println("<h1 style='color:red; text-align:center;'>❌ Invalid username or password!</h1>");
            req.getRequestDispatcher("AdminLogin.html").include(req, resp);
        } 
        else {
            HttpSession session = req.getSession(true);
            session.setAttribute("AdminBean", abean);
            req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
        }
    }
}
