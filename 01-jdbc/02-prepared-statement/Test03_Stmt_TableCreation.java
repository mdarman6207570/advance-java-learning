package com.nit.hk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test03_Stmt_TableCreation {
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		// 1.  Loading Oracle driver into jvm
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. creating connection to the db
		Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","arman","rohan");
		System.out.println("Connection is created");
		
		//3. Creating Statement object
		Statement stmt = con.createStatement();	
		System.out.println("Statement is created");
		
	
		//4. Preparing queries for tables creation 
		
		String courseTableQuery = "CREATE TABLE course(\n"  +
		"course_id NUMBER(4) PRIMARY KEY, \n"+
		"course_name VARCHAR2(50) UNIQUE NOT NULL, \n"+
		"course_fee NUMBER(7,2)\n" +
		")";
		
		
		String studentTableQuery =  
				"""
				CREATE TABLE student(
				sid NUMBER(4) PRIMARY KEY,
				sname VARCHAR2(20) NOT NULL,
				course_id NUMBER(4) REFERENCES course(course_id),
				fee		NUMBER(7,2)
				)
				""";   //Java 15v new features Text blocks (""" """)
		
		//5. Executing above queries
		stmt.execute(courseTableQuery);
		System.out.println("Course table is created");
		
		stmt.execute(studentTableQuery);
		System.out.println("Student table is created");
		
		//6.closing connection
		stmt.close();
		con.close();
	}
}
