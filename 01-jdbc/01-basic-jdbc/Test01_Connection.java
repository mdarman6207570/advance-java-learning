package com.nit.hk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01_Connection {
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		// 1.  Loading Oracle driver into jvm
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is Loaded");
		
		//2. creating connection to the db
		Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##imran2","laddu");
		System.out.println("Connection is created");
		
		//3. Printing connection object class name	
	    	System.out.println("Con:"+con);
	    	
		 //4. Closing connection 
	        con.close();
	}
	
}
