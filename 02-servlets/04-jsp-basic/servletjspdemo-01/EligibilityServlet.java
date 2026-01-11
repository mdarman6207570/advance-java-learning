package cpm.pack1;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/eligibilityServlet")
public class EligibilityServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String country = req.getParameter("country");
        String aadhar = req.getParameter("aadharNumber");
        String gender = req.getParameter("gender");

        boolean isEligible = false;
        String message = "";

        if (age <= 0) 
        {
            message = "Invalid age entered.";
        } 
        else if (gender.equalsIgnoreCase("Male")) 
        {
            if (age > 21 && age < 60) 
            {
                isEligible = true;
                message = "Eligible for marriage. Think one more time before taking decision.";
            } else {
                message = "Not eligible for marriage. Stay happy! Don’t be in hurry.";
            }
        } 
        else if (gender.equalsIgnoreCase("Female")) {
            if (age > 18 && age < 60) {
                isEligible = true;
                message = "Eligible for marriage. Think one more time before taking decision.";
            } else {
                message = "Not eligible for marriage. Stay happy! Don’t be in hurry.";
            }
        } 
        else {
            message = "Please select gender.";
        }

        
        req.setAttribute("name", name);
        req.setAttribute("age", age);
        req.setAttribute("country", country);
        req.setAttribute("aadhar", aadhar);
        req.setAttribute("gender", gender);
        req.setAttribute("message", message);

        
        RequestDispatcher rd;
        if (isEligible)
            rd = req.getRequestDispatcher("Valid.jsp");
        else
            rd = req.getRequestDispatcher("Invalid.jsp");

        rd.forward(req, res);
    }
}