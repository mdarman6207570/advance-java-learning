package login;

import java.io.IOException;

import bean.BankBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LogInServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String accno = req.getParameter("accno");
		String holderName = req.getParameter("holderName");
		
		BankBean bean = new BankBean();
		bean.setAccno(accno);
		bean.setAccholdername(holderName);
		
		int res = new LogInDAO().loginVerify(bean);
		
		if(res == 1)
        {
            HttpSession session = req.getSession();
            session.setAttribute("holderName", holderName); 
            req.getRequestDispatcher("loginSuccess.jsp").forward(req, resp); 
        }
        else
        {
            req.setAttribute("error", "Invalid account number or holder name");
            req.getRequestDispatcher("login.html").forward(req, resp);
        }
	}
}
