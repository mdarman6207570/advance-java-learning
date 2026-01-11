package com.pack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String uname = req.getParameter("username");
        String pass = req.getParameter("password");

        if ("admin@123".equals(uname) && "admin".equals(pass)) {
            req.setAttribute("message", "LOGIN SUCCESS");
            RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
            rd.forward(req, res);
        } else {
            out.println("<h3>Invalid username or password</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
        }
    }
}
