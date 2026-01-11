package com.pack1;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		UserLoginDAO DAOobj = new UserLoginDAO();
		UserBean ub = DAOobj.checkLogin(req.getParameter("uname"), req.getParameter("upwd"));
		
		if(ub == null)
		{
			req.setAttribute("msg", "Invalid Login Credentials");
			req.getRequestDispatcher("Register.jsp").forward(req, resp);
		}
		else
		{
			ServletContext context = req.getServletContext();
			context.setAttribute("UserBean", ub);
			Cookie c = new Cookie("ck1",ub.getU_fname());
			resp.addCookie(c);
			req.getRequestDispatcher("Home.jsp").forward(req, resp);
		}
	}
}
