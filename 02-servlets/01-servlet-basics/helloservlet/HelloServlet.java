package com.nit.hk.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class HelloServlet implements Servlet
{

	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		this.config = config;
		System.out.println("init(sc) is executed");	
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		//printing on server on console
		System.out.println("service(SReq, SResp) is executed");
		
		//printing on client browser
		PrintWriter out = resp.getWriter();
		out.println("Hi, Welcome to Naresh i Technologies");
	}
	
	@Override
	public void destroy() 
	{
		System.out.println("destroy() method is executed");	
	}
	
	@Override
	public ServletConfig getServletConfig() 
	{
		System.out.println("getServletConfig() method is executed");
		return config;
	}

	@Override
	public String getServletInfo() 
	{
		System.out.println("getServletInfo() method is executed");
		return "Hello Servlet";
	}
}
