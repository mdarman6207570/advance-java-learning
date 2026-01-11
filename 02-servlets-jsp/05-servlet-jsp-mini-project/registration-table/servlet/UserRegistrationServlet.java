package com.pack1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class UserRegistrationServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		UserBean ub = new UserBean();
		
		ub.setU_name(req.getParameter("uname"));
		ub.setU_password(req.getParameter("upwd"));
		ub.setU_fname(req.getParameter("fname"));
		ub.setU_lname(req.getParameter("lname"));
		ub.setU_mail(req.getParameter("mailid"));
		ub.setU_phone(req.getParameter("phone"));
		
		UserRegisterDAO dao = new UserRegisterDAO();
		int rowCount = dao.insertRecord(ub);
		
		if(rowCount==0)
		{
			req.setAttribute("msg", "Data NOT Inserted❌");
			req.getRequestDispatcher("Register.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("msg", "Record Inserted in DataBase😍");
			req.getRequestDispatcher("Register.jsp").forward(req, resp);
		}
	}
	
}
