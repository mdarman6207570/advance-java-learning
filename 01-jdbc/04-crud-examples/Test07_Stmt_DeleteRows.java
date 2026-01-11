package com.nit.hk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test07_Stmt_DeleteRows {
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		// 1.  Loading Oracle driver into jvm
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. creating connection to the db
		Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","arman","rohan");
		System.out.println("Connection is created");
		
		//3. Creating Statement object
		Statement stmt = con.createStatement();
		
		//4. Preparing queries and executing for deleting rows
		
		int rowsDeleted = 0;
		
		rowsDeleted += stmt.executeUpdate(
					"""
					delete from course
					where course_name='Oracle'
					"""
					);
		
		System.out.println(rowsDeleted + " rows are deleted");
		
		
		//5. closing connection
		stmt.close();
		con.close();

	}
}
