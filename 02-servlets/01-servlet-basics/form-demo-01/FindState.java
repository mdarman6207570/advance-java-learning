package form;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("stateinfo")
public class FindState extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String state = request.getParameter("state");
	        String capital = "";

	        if (state == null || state.isEmpty()) {
	            out.println("<h3 style='color:red;'>Please select a state!</h3>");
	            RequestDispatcher rd = request.getRequestDispatcher("index.html");
	            rd.include(request, response);
	            return;
	        }

	       
	        switch (state) {
	            case "Telangana":
	                capital = "Hyderabad";
	                break;
	            case "Bihar":
	                capital = "Patna";
	                break;
	            case "Andhrapradesh":
	                capital = "Amaravati";
	                break;
	            case "Tamilnadu":
	                capital = "Chennai";
	                break;
	            case "Maharashtra":
	                capital = "Mumbai";
	                break;
	            default:
	                capital = "Unknown";
	        }
	     
	        out.println("<h3 style='text-align:center;'>Your selected state is <b>" + state + "</b></h3>");
	        out.println("<h3 style='text-align:center;'>Capital = <b>" + capital + "</b></h3>");
	        
	}
}
