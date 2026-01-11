package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionProvider 
{

	public static void main(String[] args) throws SQLException
	{
		String className = "oracle.jdbc.driver.OracleDriver";
		String urlString = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName = "arman";
		String password = "rohan";
		
		try
		{
			Class.forName(className);
			Connection con = DriverManager.getConnection(urlString,userName,password);
			System.out.println("Connection created!!!");
			
			Statement stmt = con.createStatement();
			System.out.println("Staement Created!!!");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
