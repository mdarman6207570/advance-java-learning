package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.bean.EmployeeBean;
import com.implementation.EmployeeServiceImplementation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class SelectServletApplication extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        EmployeeServiceImplementation empService = new EmployeeServiceImplementation();
        ArrayList<EmployeeBean> employeeList = empService.select();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Employee Records</title>");
        out.println("<style>");
        out.println("body {font-family: Arial, sans-serif; background-color: #f8f9fa; text-align:center;}");
        out.println("h1 {color: #007bff;}");
        out.println("table {margin: 20px auto; border-collapse: collapse; width: 70%;}");
        out.println("th, td {border: 1px solid #333; padding: 10px; text-align: center;}");
        out.println("th {background-color: #007bff; color: white;}");
        out.println("tr:nth-child(even) {background-color: #e9ecef;}");
        out.println("</style></head><body>");

        out.println("<h1>Employee Records</h1>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Aadhaar</th></tr>");

        if (employeeList != null && !employeeList.isEmpty()) 
        {
            for (EmployeeBean eb : employeeList) 
            {
                out.println("<tr>");
                out.println("<td>" + eb.getId() + "</td>");
                out.println("<td>" + eb.getName() + "</td>");
                out.println("<td>" + eb.getAadhaar() + "</td>");
                out.println("</tr>");
            }
        }
        else 
        {
            out.println("<tr><td colspan='3'>No Records Found</td></tr>");
        }

        out.println("</table>");
        out.println("<br><a href='Welcome.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
