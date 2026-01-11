import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/calculate")
public class CalculationApp implements Servlet {

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
		
		int fNum = Integer.parseInt(req.getParameter("fnum"));
		int sNum = Integer.parseInt(req.getParameter("snum"));
		
		String op = req.getParameter("op");
		
		if(op.equals("+"))
		{
			pw.print("Addition is :"+(fNum+sNum));
		}
		else if(op.equals("-"))
		{
			pw.print("Substarction is :"+(fNum-sNum));
		}
		else if(op.equals("*"))
		{
			pw.print("Multiplication is :"+(fNum*sNum));
		}
		else if(op.equals("/"))
		{
			pw.print("Divison is :"+(fNum/sNum));
		}
		else if(op.equals("%"))
		{
			pw.print("Remainder is :"+(fNum%sNum));
		}
		else
		{
			pw.print("Invalid Calculation!!!");
		}
	}

}
