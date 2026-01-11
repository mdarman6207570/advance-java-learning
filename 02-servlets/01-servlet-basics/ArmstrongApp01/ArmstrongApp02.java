package com.day1.armstrong;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ArmstrongApp02 implements Servlet 
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
		
		int num = 153;
		int temp = num;
		int sum = 0;
		
		while(num != 0)
		{
			int r = num%10;
			sum += r*r*r;
			num /=10;
		}
		
		if(temp == num)
			pw.print("153 is an Armstrong number");
		else
			pw.print("153 is NOT an Armstrong number");
		
		
	}

}
