package com.nit.hk.servlets;

import java.io.PrintWriter;
import java.io.IOException;

import java.sql.Timestamp;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletException;

public class DateServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException
	{
		//request processing logic(blogic)
		long milliSecs = System.currentTimeMillis();
		Timestamp ts = new Timestamp(milliSecs); 
		
		//response generation logic
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Today's Date and Time is <br>"+ts);
	} 
}
