package servlet.mydemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/submit")
public class MyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println("Name :"+name);
		System.out.println("Email :"+email);
		
		PrintWriter out = response.getWriter();
		
		out.println("Name :"+name);
		out.println("Email :"+email);
			
	}
}
