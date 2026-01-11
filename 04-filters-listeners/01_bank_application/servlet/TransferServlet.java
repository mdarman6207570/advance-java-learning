package ServletClasses;

import java.io.IOException;

import DAO.TransactionDAO;
import Entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TransferServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User sender = (User) session.getAttribute("user");

        if (sender == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String receiverAccount = request.getParameter("receiverAccount");
        double amount = Double.parseDouble(request.getParameter("amount"));

        TransactionDAO dao = new TransactionDAO();
        boolean success = dao.transferAmount(sender.getAccountNumber(), receiverAccount, amount);

        if (success) {
            response.sendRedirect("dashboard.jsp?msg=Transfer Successful");
        } else {
            response.sendRedirect("makePayment.jsp?error=Transfer Failed");
        }
    }
}
