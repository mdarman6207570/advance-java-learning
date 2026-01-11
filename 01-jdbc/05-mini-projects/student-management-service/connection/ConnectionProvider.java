package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static String driverName="oracle.jdbc.driver.OracleDriver";
    private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
    private static String username="arman";
    private static String password="rohan";
    
    private static Connection con;
    
    private ConnectionProvider() {
    	 
    }
    public static Connection getConnection() {
    	 if(con==null) {
    		  try {
				Class.forName(driverName);
				con=DriverManager.getConnection
						(url, username, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 
    	 return con;
    }
    
    
}
