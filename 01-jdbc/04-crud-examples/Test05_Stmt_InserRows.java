package com.nit.hk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test05_Stmt_InserRows {
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		// 1.  Loading Oracle driver into jvm
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. creating connection to the db
		Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","arman","rohan");
		System.out.println("Connection is created");
		
		//3. Creating Statement object
		Statement stmt = con.createStatement();
		
		//4. Execute queries
		stmt.executeUpdate("""
                INSERT INTO course(course_id, course_name, course_fee)
                VALUES(course_seq.nextval, 'Core Java', 3500)
            """);

            stmt.executeUpdate("""
                INSERT INTO course(course_id, course_name, course_fee)
                VALUES(course_seq.nextval, 'Oracle', 2500)
            """);

            stmt.executeUpdate("""
                INSERT INTO course(course_id, course_name, course_fee)
                VALUES(course_seq.nextval, 'HTML, CSS, JS', 2500)
            """);

            stmt.executeUpdate("""
                INSERT INTO course(course_id, course_name, course_fee)
                VALUES(course_seq.nextval, 'Adv Java', 3500)
            """);

            System.out.println("Rows are inserted successfully.");

		
		//5. closing connection
		stmt.close();
		con.close();

	}
}