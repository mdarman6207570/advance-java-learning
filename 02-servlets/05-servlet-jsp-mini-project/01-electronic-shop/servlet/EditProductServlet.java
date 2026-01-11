package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit")
public class EditProductServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	    HttpSession session = req.getSession();
	    if(session == null)
	    {
	    	  req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
	    }
	    else
	    {
	    	String pcode = req.getParameter("pcode");
	    	ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("ProductList");
	    	Iterator<ProductBean> i = al.iterator();
	    	ProductBean pb = null;
	    	while(i.hasNext())
	    	{
	    		pb = i.next();
	    		if(pcode.equals(pb.getPcode()))
	    		{
	    			break;
	    		}
	    	}
	    	req.setAttribute("pbitem", pb);
	    	req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
	    }
	}
}
