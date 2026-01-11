import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/avg")
public class StudentDataServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        int sub1 = Integer.parseInt(req.getParameter("sub1"));
        int sub2 = Integer.parseInt(req.getParameter("sub2"));
        int sub3 = Integer.parseInt(req.getParameter("sub3"));
        int sub4 = Integer.parseInt(req.getParameter("sub4"));
        int sub5 = Integer.parseInt(req.getParameter("sub5"));

       
        if (id >= 10 && id <= 100 && sub1 > 35 && sub2 > 35 && sub3 > 35 && sub4 > 35 && sub5 > 35) {
           
            RequestDispatcher rd = req.getRequestDispatcher("calculate");
            rd.forward(req, res);
        }
        else 
        {
            out.println("<h3 style='color:red;'>Invalid ID or marks (must be between 10–100 and all > 35)</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("Input.html");
            rd.include(req, res);
        }
    }
}
