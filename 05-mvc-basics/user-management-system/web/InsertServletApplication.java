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

@WebServlet("/insert")
public class InsertServletApplication extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeBean eb = new EmployeeBean();
        EmployeeServiceImplementation emp = new EmployeeServiceImplementation();

        eb.setId(Integer.parseInt(req.getParameter("id")));
        eb.setName(req.getParameter("name"));
        eb.setAadhaar(req.getParameter("aadhar"));

        int rowcount = emp.insert(eb);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (rowcount > 0) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Data Inserted</title>");
            out.println("<style>");
            out.println("body {font-family: Arial, sans-serif; background-color:#f8f9fa; margin:0; padding:0;}");
            out.println(".overlay-message {");
            out.println("position: fixed;");
            out.println("top: 15%;");
            out.println("left: 50%;");
            out.println("transform: translate(-50%, -50%);");
            out.println("color: green;");
            out.println("font-size: 28px;");
            out.println("font-weight: bold;");
            out.println("z-index: 1000;");
            out.println("}");
            out.println("</style></head><body>");

            // ✅ Centered floating success message
            out.println("<div class='overlay-message'>DATA INSERTED SUCCESSFULLY</div>");

            // ✅ Include main page below
            RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
            rd.include(req, resp);

            out.println("</body></html>");
        } else {
            out.println("<h2 style='color:red;text-align:center;'>Insertion Failed!</h2>");
        }
    }
}
