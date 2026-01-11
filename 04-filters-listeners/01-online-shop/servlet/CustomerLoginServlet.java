package com.task.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.task.DAO.CustomerLoginDAO;
import com.task.bean.CustomerBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CustomerLogin")
public class CustomerLoginServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerBean cb = new CustomerLoginDAO().checkData(req.getParameter("uname"), req.getParameter("pass"));
		if (cb == null) {
			PrintWriter pw = resp.getWriter();
			resp.setContentType("text/html");
			pw.print("<center><h1>Invalid Credential!!!</h1></center>");
			req.getRequestDispatcher("customer.html").include(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("CustomerBean", cb);
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, resp);
		}
	}
}