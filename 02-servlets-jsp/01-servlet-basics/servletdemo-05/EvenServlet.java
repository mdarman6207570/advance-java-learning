package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/es")
public class EvenServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		int n =	Integer.parseInt(req.getParameter("num"));
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		if(n%2 == 0)
		{
		pw.println("<center>");
		pw.print(n+"<h1> is an Even Number</h1><br><br>");
		pw.println("</center>");
		}
		
		else
		{
			pw.println("<center>");
			pw.print("<h1> "+n+" is an Odd Number</h1>");
			pw.println("</center>");
		}
		
	}
}
