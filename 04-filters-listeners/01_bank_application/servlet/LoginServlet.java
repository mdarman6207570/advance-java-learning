package ServletClasses;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import DAO.UserDAO;
import Entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO dao = new UserDAO();
        User user = dao.validateUser(username, password);
        if (user != null) {
        	System.out.println("Dashboread");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
        	System.out.println("index");
            request.setAttribute("msg", "Invalid Username or Password!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
