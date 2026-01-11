package user;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import implementation.UserBeanDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String uname = req.getParameter("username");
        String upwd = req.getParameter("password");

        UserBeanDAO dao = new UserBeanDAO();
        int status = dao.verify(uname, upwd);

        if (status == 1) 
        {
            
            RequestDispatcher rd = req.getRequestDispatcher("booking.html");
            rd.forward(req, res);
        }
        else 
        {
            
            out.println("<html><body style='text-align:center;'>");
            out.println("<h3 style='color:red;'>Invalid Username or Password</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
            out.println("</body></html>");
        }
    }
}
