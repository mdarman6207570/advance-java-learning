package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect 
{
	private static Connection con = null;
	
	public static Connection getConnection() 
    {
        try 
        {
            if (con == null || con.isClosed()) 
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(DBInfo.URL, DBInfo.UNAME, DBInfo.UPWD);
            }
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            e.printStackTrace();
        }
        return con;
    }
}