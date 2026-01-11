package com.pack1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/aps")
public class AddProductServlet  extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if (session==null) 
		{
			req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
			return;
		}
		else
		{
			ProductBean pb = new ProductBean();
	        pb.setPcode(req.getParameter("pcode"));
	        pb.setPname(req.getParameter("pname"));
	        pb.setPcompany(req.getParameter("pcom"));
	        pb.setPprice(req.getParameter("pprice"));
	        pb.setPqty(req.getParameter("pqty"));
			
			int rowcount = new AddProductDAO().insertProduct(pb);
			if (rowcount > 0) 
			{
	            req.setAttribute("msg", "✅ Product added to inventory successfully!");
	            req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
	        }
			else
			{
	            throw new RuntimeException("❌ Product inventory not updated!");
	        }
		}
	}
}
