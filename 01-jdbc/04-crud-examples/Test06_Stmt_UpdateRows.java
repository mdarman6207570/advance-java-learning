package com.nit.hk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test06_Stmt_UpdateRows {
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		// 1.  Loading Oracle driver into jvm
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. creating connection to the db
		Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","arman","rohan");
		System.out.println("Connection is created");
		
		//3. Creating Statement object
		Statement stmt = con.createStatement();
		
		//4. Preparing queries and executing for inserting rows
		int rowsUpdated = 0;
		
		rowsUpdated += stmt.executeUpdate(
				"""
				update course
				set course_fee=5500
				where course_name='Core Java'
				"""
				);
	
	rowsUpdated += stmt.executeUpdate(
				"""
				update course
				set course_fee=4500
				where course_name='Oracle'
				"""
				);
	
	rowsUpdated += stmt.executeUpdate(
				"""
				update course
				set course_fee=10500
				where course_name='Adv Java'
				"""
				);

	
	System.out.println(rowsUpdated + " rows are updated");

		
		//5. closing connection
		stmt.close();
		con.close();

	}
}
