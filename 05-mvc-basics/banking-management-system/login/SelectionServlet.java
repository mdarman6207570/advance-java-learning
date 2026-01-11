package login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/selection")
public class SelectionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String action = req.getParameter("action");
        if ("deposit".equals(action)) 
        {
            req.getRequestDispatcher("deposit.html").forward(req, resp);
        }
        else if ("transfer".equals(action)) 
        {
            req.getRequestDispatcher("transfer.html").forward(req, resp);
        }
        else if("back".equals(action))
        {
        	req.getRequestDispatcher("application.html").forward(req, resp);
        }
        else 
        {
            resp.sendRedirect("application.html");
        }
    }
}
