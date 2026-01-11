package com.task.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.task.DAO.UpdateCustomerProductDAO;
import com.task.bean.ProductBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateCustomerProduct")
public class UpdateCustomerProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null) {
			res.sendRedirect("customer.html?error=1");
		} else {
			ProductBean pbean = new ProductBean();
			pbean.setpCode(req.getParameter("pcode"));
			pbean.setpName(req.getParameter("pname"));
			pbean.setpCompany(req.getParameter("pcompany"));
			pbean.setpPrice(Integer.parseInt(req.getParameter("pprice")));
			pbean.setpQty(Integer.parseInt(req.getParameter("pqty")));
			int item = Integer.parseInt(req.getParameter("preq"));

			UpdateCustomerProductDAO custDao = new UpdateCustomerProductDAO();
			boolean checkItems = custDao.checkItems(pbean, item);
			if (checkItems) {
				int data = custDao.updateProduct(pbean,item);
				if (data > 0) {
					req.setAttribute("item", item);
					req.setAttribute("ProductBean", pbean);
					req.setAttribute("msg", "Product Buy Successfull !");
					req.getRequestDispatcher("OrderConfirmed.jsp").forward(req, res);

				} else {
					throw new RuntimeException("Data not inserted .");
				}

			} else {
				res.sendRedirect("BuyProduct.jsp?error=1");
			}

		}
	}
}
