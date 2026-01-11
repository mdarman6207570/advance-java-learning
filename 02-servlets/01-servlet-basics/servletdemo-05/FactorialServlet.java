package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/fs")
public class FactorialServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		int n =	Integer.parseInt(req.getParameter("num"));
		int fact = 1;
		
		for(int i=1;i<=n;i++)
		{
			fact *=i;
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<center>");
		pw.print("<h1>The factorial of "+n+" is :"+fact+"</h1>");
		pw.println("</center>");
	}
	
}
