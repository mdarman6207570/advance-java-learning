package request_dispatcher;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class ValidateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("uname");
        String password = request.getParameter("upwd");

        
        if ("arman".equals(name) && "1234".equals(password)) {
            request.setAttribute("username", name);

            
            RequestDispatcher rd = request.getRequestDispatcher("welcome");
            rd.forward(request, response);
        } else {
            out.println("<h3 style='color:red;'>Sorry, username or password error!</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
    }
}
