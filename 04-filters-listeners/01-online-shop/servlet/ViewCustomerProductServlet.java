package com.task.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.task.DAO.ViewProductDAO;
import com.task.bean.ProductBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewCustomerProduct")
public class ViewCustomerProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session==null) {
			req.getRequestDispatcher("customer.html").forward(req, res);
		}else {
			ArrayList<ProductBean> al = new ViewProductDAO().viewProducts();
			session.setAttribute("ProductList", al);
			req.getRequestDispatcher("ViewCustomerProduct.jsp").forward(req, res);
		}
	}
}
