package com.pack1;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
       Cookie arr[] = req.getCookies();
       String fname = null;
       
       if(arr == null)
       {
    	      req.setAttribute("msg", "session expire!!");
    	      req.getRequestDispatcher("Register.jsp").forward(req, resp);
       }
       else 
       {
    	      ServletContext context = req.getServletContext();
    	      UserBean ub = (UserBean)context.getAttribute("UserBean");
    	      
    	      ub.setU_fname(req.getParameter("f_name"));
    	      ub.setU_lname(req.getParameter("l_name"));
    	      ub.setU_mail(req.getParameter("mail_id"));
    	      ub.setU_phone(req.getParameter("phone_no"));
    	      
    	      int rowcount = new UpdateProfileDAO().updateData(ub);
    	      
    	      if(rowcount>0)
    	      {
    	    	     req.setAttribute("msg", "Profile Updated!!!");
    	    	     for(Cookie c : arr)
     	    	    	 if("ck1".equals(c.getName()))
     	    	    		 fname = c.getValue();
    	    	     req.setAttribute("fname", fname);
    	    	     req.getRequestDispatcher("UpdateProfile.jsp").forward(req, resp);
    	      }
    	      else
    	      {
    	    	     throw new RuntimeException("Techincal Error!!!");
    	      }
       }
	}
}
