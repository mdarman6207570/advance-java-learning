package com.nit.hk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test11_Pstmt_InsertRow_Dynavalues 
{
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","arman","rohan");
		System.out.println("Connection Established");
		
	
		//3. creating dynamically SQL with placeholder 
		String InsertQuery = "Insert into course(course_id,course_name,course_fee)VALUES(course_seq.nextval,?,?)";
		
		//4. creating prepare statement with the SQL Query
		PreparedStatement pstmt = con.prepareStatement(InsertQuery);
		System.out.println("Prepared statement is created with pre-compiled SQL stmt");
		
		//5.Reading values for place holder from the keyboard
		Scanner sc = new Scanner(System.in);
		String choice;
		
		do
		{
			System.out.println("Enter course Name :");
			String courseName = sc.nextLine().trim();
			
			System.out.println("Enter course fee: ");
			double courseFee = sc.nextDouble();
			sc.nextLine();
			
			//6. setting values to pstmt object
			pstmt.setString(1, courseName);
			pstmt.setDouble(2, courseFee);
			
			//7. Executing Query with dynamic values
			int rowsInserted = pstmt.executeUpdate();
			System.out.println(rowsInserted+" rows inserted");
			
			System.out.println("Do you want to continue (Y/N)? :");
			choice = sc.nextLine();
			
			sc.close();
		}
		while(choice.equalsIgnoreCase("Y"));
		
		System.out.println("\n***** Bye, Thank you, Visit Again ****");
		
	}
}
