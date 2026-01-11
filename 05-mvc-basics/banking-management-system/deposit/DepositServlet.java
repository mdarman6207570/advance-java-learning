package deposit;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import bean.BankBean;


@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Retrieve deposit amount (and optionally account info from session)
        String accno = (String) req.getSession().getAttribute("accno");
        String holderName = (String) req.getSession().getAttribute("holderName"); // or from login
        String amountStr = req.getParameter("amount");
        double amount = Double.parseDouble(amountStr);

        BankBean bean = new BankBean();
        bean.setAccno(accno);
        bean.setAccholdername(holderName);
        bean.setDepositAmount(amount);

        boolean success = new DepositDAO().deposit(bean);
        if (success) {
            req.getRequestDispatcher("transfersuccess.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Deposit failed. Please try again.");
            req.getRequestDispatcher("fail.jsp").forward(req, resp);
        }
    }
}
