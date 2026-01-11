package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewEmployeeServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException ,IOException
	{
		ArrayList<EmployeeBean> al = new ViewEmpDAO().retrieve();
		req.setAttribute("List", al);
		req.getRequestDispatcher("ViewEmployee.jsp").forward(req, resp);
	}
}
