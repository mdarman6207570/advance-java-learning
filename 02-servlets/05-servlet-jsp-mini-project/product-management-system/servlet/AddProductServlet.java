package com.pack1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ProductBean bean = new ProductBean();
		
		bean.setPcode(req.getParameter("pcode"));
		bean.setPname(req.getParameter("pname"));
		bean.setPcompany(req.getParameter("pcompany"));
		bean.setPprice(req.getParameter("pprice"));
		bean.setPqty(req.getParameter("pqty"));
		
		AddProductDAO dao = new AddProductDAO();
		int rowCount = dao.insert(bean);
		
		if(rowCount > 0)
		{
			req.setAttribute("msg", "Product Added😍!");
			req.getRequestDispatcher("InsertProduct.jsp").forward(req, resp);
		}
		else
        	throw new RuntimeException("Product not Added😒!"); 
	}
}
