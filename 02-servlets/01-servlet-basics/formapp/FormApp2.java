import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/productform")
public class FormApp2 implements Servlet 
{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		String userName = req.getParameter("uname");
		String password = req.getParameter("pwd");
		int pQuantity = Integer.parseInt(req.getParameter("pqty"));
		double pPrice = Double.parseDouble(req.getParameter("pprice"));
		String pName = req.getParameter("pname");
		int pId = Integer.parseInt(req.getParameter("pid"));
		
		if(userName.equals("Arman") && password.equals("java is awesome"))
		{
			pw.print("Welcome "+userName);
			pw.print("<br>");			
			pw.print("You did the TASK!!!!");
			pw.print("<br>");	
			pw.print("<br>");	
		}
		else
		{
			pw.print("Welcome "+userName);
			pw.print("<br>");
			pw.print("Invalid credentials!!!!");
		}
		
		if(pQuantity <= 5)
		{
			//pPrice += pPrice*0.10; 
		}
		
		pw.print("<br>");	
		pw.print("Product Name is :"+pName);
		pw.print("<br>");
		
		pw.print("Product Id is :"+pId);
		pw.print("<br>");
		
		pw.print("Product Quantity is :"+pQuantity);
		pw.print("<br>");
		
		pw.print("Product Price is :"+pPrice+"Rs.");
		pw.print("<br>");
		
		pw.print("Product Total Price is :"+(pPrice*pQuantity) +"RS...");
		pw.print("<br>");
		
	}

}
