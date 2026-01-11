package user;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        
        String pname = req.getParameter("pname");
        String phone = req.getParameter("phone");
        int num = Integer.parseInt(req.getParameter("num"));
        String classType = req.getParameter("classType");

        
        double pricePerTicket = 0;
        switch (classType) {
            case "General":
                pricePerTicket = 100;
                break;
            case "Sleeper":
                pricePerTicket = 500;
                break;
            case "3rdAC":
                pricePerTicket = 1500;
                break;
            case "2ndAC":
                pricePerTicket = 2000;
                break;
            case "1stAC":
                pricePerTicket = 4000;
                break;
        }

        double totalFare = pricePerTicket * num;

        
        out.println("<html><head><title>Train Ticket Receipt</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background-color: #f2f6fc; text-align:center; }");
        out.println(".ticket { background:#fff; padding:20px; margin:50px auto; width:400px; border-radius:10px; box-shadow:0 0 10px rgba(0,0,0,0.2); }");
        out.println("h2 { color:#2f80ed; }");
        out.println("</style></head><body>");
        out.println("<div class='ticket'>");
        out.println("<h2>Train Ticket Receipt</h2>");
        out.println("<hr>");
        out.println("<p><b>Passenger Name:</b> " + pname + "</p>");
        out.println("<p><b>Phone Number:</b> " + phone + "</p>");
        out.println("<p><b>Class Type:</b> " + classType + "</p>");
        out.println("<p><b>Number of Passengers:</b> " + num + "</p>");
        out.println("<p><b>Fare per Ticket:</b> ₹" + pricePerTicket + "</p>");
        out.println("<p><b>Total Fare:</b> ₹" + totalFare + "</p>");
        out.println("<hr>");
        out.println("<h3>✅ Booking Confirmed!</h3>");
        out.println("<a href='login.html'>Logout</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
