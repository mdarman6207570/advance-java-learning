package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import com.bean.EmployeeBean;
import com.implementation.EmployeeServiceImplementation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServletApplication extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
  

        
        EmployeeBean eb = new EmployeeBean();
        eb.setId(Integer.parseInt(req.getParameter("pid")));

        EmployeeServiceImplementation empService = new EmployeeServiceImplementation();
        int result = empService.delete(eb);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // ✅ Display success or failure message
        if (result > 0) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Delete Status</title>");
            out.println("<style>");
            out.println("body {font-family: Arial, sans-serif; text-align:center; background-color:#f8f9fa;}");
            out.println(".msg {color: red; font-size: 26px; font-weight: bold; margin-top: 50px;}");
            out.println("</style></head><body>");
            out.println("<div class='msg'>USER DELETED SUCCESSFULLY</div>");
            
            // Include home page below
            RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
            rd.include(req, resp);

            out.println("</body></html>");
        } 
        else {
            out.println("<!DOCTYPE html><html><body style='text-align:center;'>");
            out.println("<h2 style='color:red;'>Delete Failed! No User Found with This ID 🤣</h2>");
            out.println("<a href='Welcome.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }
}
