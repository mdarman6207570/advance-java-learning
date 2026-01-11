package com.task.servlet;

import java.io.IOException;

import com.task.DAO.AddProductDAO;
import com.task.bean.ProductBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session==null) {
			req.getRequestDispatcher("admin.html").forward(req, res);;
		}else {
			ProductBean pbean=new ProductBean();
			pbean.setpCode(req.getParameter("pcode"));
			pbean.setpName(req.getParameter("pname"));
			pbean.setpCompany(req.getParameter("pcom"));
			pbean.setpPrice(Integer.parseInt(req.getParameter("pprice")));
			pbean.setpQty(Integer.parseInt(req.getParameter("pqty")));
          
			int row=new AddProductDAO().insertProduct(pbean);
			if(row>0) {
				req.setAttribute("msg","Product added to inventory");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}else {
				throw new RuntimeException("Product inventory not updated");
			}
		}
	}

}
