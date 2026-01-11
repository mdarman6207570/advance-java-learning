package votingeligibility;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/votingeligibility")
public class VotingServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        String ageParam = req.getParameter("age");
        String country = req.getParameter("country");

        int age = Integer.parseInt(ageParam);

        if (age >= 18 && country.equalsIgnoreCase("india")) {
            pw.print("<h2 style='color:green;'>Eligible for Voting!!!</h2>");
        } else {
            pw.print("<h2 style='color:red;'>NOT Eligible for Voting!!!</h2>");
        }
    }
}
