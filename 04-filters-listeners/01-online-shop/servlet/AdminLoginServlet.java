package com.task.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.task.DAO.AdminLoginDAO;
import com.task.bean.AdminBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminBean ab = new AdminLoginDAO().checkData(req.getParameter("uname"), req.getParameter("upass"));
		if (ab == null) {
			PrintWriter pw=resp.getWriter();
			resp.setContentType("text/html");
			pw.print("<center><h1>Invalid Credential!!!</h1></center>");
			req.getRequestDispatcher("admin.html").include(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("AdminBean", ab);
			req.getRequestDispatcher("adminlogin.jsp").forward(req, resp);
		}
	}
}
