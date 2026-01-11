package com.connection_provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect
{
	public static Connection con;
	
	private DBConnect() {}
	
	static
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(DBInfo.URL,DBInfo.UNAME,DBInfo.UPWD);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
            e.printStackTrace();
        }
	}
}
