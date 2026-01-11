package com.pack1;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ms")
public class MainServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String data = req.getParameter("choice");
		if(data.equals("Factorial"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("/fs");
			rd.forward(req, resp);
		}
		
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("/es");
			rd.forward(req, resp);
		}
	}

	

}
