package com.pack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        String pname = req.getParameter("personName");
        String country = req.getParameter("country");
        String aadhaar = req.getParameter("aadhaar");

        
        boolean valid = true;
        String msg = "";

        if (uname == null || uname.length() != 10 ||
            !uname.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@]).{10}")) {
            valid = false;
            msg = "Invalid username format.";
        } else if (pname == null || pname.trim().isEmpty()) {
            valid = false;
            msg = "Person name cannot be empty.";
        } else if (!"India".equalsIgnoreCase(country)) {
            valid = false;
            msg = "Country must be India.";
        } else if (!aadhaar.matches("\\d{12}")) {
            valid = false;
            msg = "Aadhaar must be 12 digits.";
        }

        if (valid) {
            out.println("<h3>Registration successful! Please login.</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
        } else {
            out.println("<h3>Registration failed: " + msg + "</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("register.html");
            rd.include(req, res);
        }
    }
}
