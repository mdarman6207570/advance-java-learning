package com.pack1;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/person")
public class PersonServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String mobile = req.getParameter("mobile");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobby");

        // Combine all selected hobbies into a single string
        String hobbyList = "";
        if (hobbies != null) {
            hobbyList = String.join(", ", hobbies);
        }

        out.println("<html><body><center>");
        out.println("<h2>Person Details (Table)</h2>");
        out.println("<table border='1' cellpadding='10' style='border-collapse:collapse;'>");
        out.println("<tr><th>Name</th><th>Age</th><th>Mobile</th><th>Gender</th><th>Hobbies</th></tr>");
        out.println("<tr>");
        out.println("<td>" + name + "</td>");
        out.println("<td>" + age + "</td>");
        out.println("<td>" + mobile + "</td>");
        out.println("<td>" + gender + "</td>");
        out.println("<td>" + hobbyList + "</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</center></body></html>");
    }
}
