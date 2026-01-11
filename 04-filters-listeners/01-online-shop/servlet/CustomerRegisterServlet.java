package com.task.servlet;

import java.io.IOException;

import com.task.DAO.CustomerRegisterDAO;
import com.task.bean.CustomerBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerRegister")
public class CustomerRegisterServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		CustomerBean cb=new CustomerBean();
		
		cb.setUserName(req.getParameter("uname"));
		cb.setPassword(req.getParameter("pass"));
		cb.setFirstName(req.getParameter("fname"));
		cb.setLastName(req.getParameter("lname"));
		cb.setAddress(req.getParameter("address"));
		cb.setMailid(req.getParameter("email"));
		cb.setMobile(req.getParameter("mobile"));
		
		int data=new CustomerRegisterDAO().insertData(cb);
		if(data>0) {
			req.getRequestDispatcher("customer.html").forward(req, res);
		}else {
			throw new RuntimeException("Customer Not Registered");
		}
	
}
}
