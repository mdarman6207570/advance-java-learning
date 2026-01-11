package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.BankBean;
import connection.DBConnect;

public class LogInDAO 
{
	public int loginVerify(BankBean bean)
	{
		int res =0;
		try
		{
			Connection con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from bankaccount where accno=? and accholdername=?");
			
			ps.setString(1, bean.getAccno());
			ps.setString(2, bean.getAccholdername());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				res =1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}
}
