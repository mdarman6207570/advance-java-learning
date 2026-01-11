package com.nit.hk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*Program #2: Develop a program to create new schema(user) in Oracle DBd*/

public class Test02_Stmt_SchemaCreation 
{
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		// 1.  Loading Oracle driver into jvm
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. creating connection to the db
		Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Arman123");
		
		//3. Creating Statement object
		Statement stmt = con.createStatement();	
		System.out.println("Statement is created");
		
	
		//4. Executing queries
		stmt.execute("ALTER SESSION SET \"_ORACLE_SCRIPT\" = true");
		
		stmt.execute("CREATE USER arman143 IDENTIFIED BY rohan");
		stmt.execute("GRANT connect, resource, unlimited tablespace to arman");
		
		System.out.println("User is created and DBA permissions are granted");
		
		//5. closing connections
		stmt.close();
		con.close();
	}
}
