package com.neonnumprogram;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class NeonNumberCheckup implements Servlet 
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
		
		int num = 9;
		int sum = 0;
		int sqrt = num*num;
		
		while(sqrt !=0)
		{
			int r = sqrt%10;
			sum += r;
			sqrt /=10;
		}
		
		if(sum == num)
			pw.print("9 is a Neon number");
		else
			pw.print("9 is not a Neon number");
	}

}
