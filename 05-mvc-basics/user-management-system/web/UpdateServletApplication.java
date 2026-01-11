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

@WebServlet("/update")
public class UpdateServletApplication extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
  
        EmployeeBean eb = new EmployeeBean();
        eb.setId(Integer.parseInt(req.getParameter("pid")));
        eb.setName(req.getParameter("pname"));
        eb.setAadhaar(req.getParameter("aadhar"));

        
        EmployeeServiceImplementation empService = new EmployeeServiceImplementation();
        int result = empService.update(eb);

        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // ✅ Success message with same style as Insert
        if (result > 0) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Update Successful</title>");
            out.println("<style>");
            out.println("body {font-family: Arial, sans-serif; text-align:center; background-color:#f8f9fa;}");
            out.println(".msg {color: blue; font-size: 26px; font-weight: bold; margin-top: 50px;}");
            out.println("</style></head><body>");
            out.println("<div class='msg'>DATA UPDATED SUCCESSFULLY</div>");
            
            RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
            rd.include(req, resp);

            out.println("</body></html>");
        } 
        else {
            out.println("<!DOCTYPE html><html><body style='text-align:center;'>");
            out.println("<h2 style='color:red;'>Update Failed! No User Found with This ID</h2>");
            out.println("<a href='Welcome.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }
}
