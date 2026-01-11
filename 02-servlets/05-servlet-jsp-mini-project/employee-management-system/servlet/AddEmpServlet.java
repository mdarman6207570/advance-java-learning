package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addemp")
public class AddEmpServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {

        EmployeeBean bean = new EmployeeBean();
        bean.setId(req.getParameter("id"));
        bean.setfName(req.getParameter("first"));
        bean.setlName(req.getParameter("last"));
        bean.setSalary(Integer.parseInt(req.getParameter("sal")));
        bean.setAddress(req.getParameter("address"));

        AddEmpDao add = new AddEmpDao();
        int rowCount = add.insertData(bean);


        if (rowCount > 0)
        {
           req.setAttribute("msg", "Employee Inserted!!!");
		   req.getRequestDispatcher("InsertEmp.jsp").forward(req, resp);
        }
        
        else
        	throw new RuntimeException("Employee not Inserted!!!"); 
    }
}
