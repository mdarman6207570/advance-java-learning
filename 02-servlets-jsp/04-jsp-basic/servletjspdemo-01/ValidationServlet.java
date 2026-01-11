package cpm.pack1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");
        String country = req.getParameter("country");
        String aadhar = req.getParameter("aadharNumber");
        String gender = req.getParameter("gender");

       
        if (name == null || name.trim().isEmpty()) 
        {
        	RequestDispatcher rd = req.getRequestDispatcher("ValidationServlet");
            rd.forward(req, res);
        }

        else if (aadhar == null || aadhar.length() != 12 || aadhar.equals("000000000000")) 
        {
        	RequestDispatcher rd = req.getRequestDispatcher("ValidationServlet");
            rd.forward(req, res);
        }

        else
        {
        RequestDispatcher rd = req.getRequestDispatcher("eligibilityServlet");
        rd.forward(req, res);
        }
    }
}
