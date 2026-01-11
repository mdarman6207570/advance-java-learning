package com.fibonacciseries;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FibonacciServlet implements Servlet
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		
		int num = 10;
		
		
		int a = 0;
		int b = 1;
		
	    pw.print(a+" "+b+" ");
		for(int i=1;i<=10;i++)
		{
		    int c = a+b;
		    pw.print(c+" ");
		    a=b;
		    b=c;
		}
	}

}
