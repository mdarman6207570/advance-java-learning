import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/calculate")
public class CalculateServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String address = req.getParameter("address");
        int id = Integer.parseInt(req.getParameter("id"));
        
        int sub1 = Integer.parseInt(req.getParameter("sub1"));
        int sub2 = Integer.parseInt(req.getParameter("sub2"));
        int sub3 = Integer.parseInt(req.getParameter("sub3"));
        int sub4 = Integer.parseInt(req.getParameter("sub4"));
        int sub5 = Integer.parseInt(req.getParameter("sub5"));

        double avg = (sub1 + sub2 + sub3 + sub4 + sub5) / 5.0;

        out.println("<h2>Student Details</h2>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>ID:</b> " + id + "</p>");
        out.println("<p><b>Address:</b> " + address + "</p>");
        out.println("<p><b>Sub1:</b> " + sub1 + "</p>");
        out.println("<p><b>Sub2:</b> " + sub2 + "</p>");
        out.println("<p><b>Sub3:</b> " + sub3 + "</p>");
        out.println("<p><b>Sub4:</b> " + sub4 + "</p>");
        out.println("<p><b>Sub5:</b> " + sub5 + "</p>");
        out.println("<h3 style='color:green;'>Average Marks: " + avg + "</h3>");
    }
}
