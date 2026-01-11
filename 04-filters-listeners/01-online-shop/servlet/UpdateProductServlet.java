package com.task.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.task.DAO.UpdateProductDAO;
import com.task.bean.ProductBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/UpdateProduct")
public class UpdateProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session == null) {
			req.getRequestDispatcher("admin.html").forward(req, res);
		} else {
			String pcode = req.getParameter("pcode");
			ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("ProductList");
			Iterator<ProductBean> i = al.iterator();
			ProductBean pb = null;
			while (i.hasNext()) {
				pb = i.next();
				if (pcode.equals(pb.getpCode())) {
					break;
				}
			}
			pb.setpPrice(Integer.parseInt(req.getParameter("pprice")));
			pb.setpQty(Integer.parseInt(req.getParameter("pqty")));
			
			int rowCount=new UpdateProductDAO().updateProduct(pb);
			if(rowCount>0) {
				req.setAttribute("msg","Product inventory updated");
				req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
			}else {
				throw new RuntimeException("Product inventory updation failed");
			}

		}
	}
}
