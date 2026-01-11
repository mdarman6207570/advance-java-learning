package com.day1.program1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class PrimeCheckApp01 implements Servlet 
{

	@Override
	public void destroy() 
	{
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
		
		int num = 17;
		boolean isPrime = true; 
		for(int i=2;i<num/2;i++)
		{
			if(num%i == 0) isPrime=false;
		}	
		if(isPrime)
			pw.print("17 is a prime number");
		else
		    pw.print("17 is not a prime number");
			
	}
	

}
