package com.palindrome;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class PalindromeProgram implements Servlet 
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
		
		int num = 121;
		int temp = num;
		int rev = 0;
		
		while(num != 0)
		{
			int r = num%10;
			rev = rev*10 + r;
			num /= 10;
		}
		
		if(temp == rev)
		    pw.print(temp+" is a Palindrome number");
		else
			pw.print(temp+" is not a Palindrome number");

	}

}
