package com.nit.hk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test14_Psmt__Student_InsertRows 
{
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","arman","rohan");
		
		//Retrieving all course name from course table 
		try(
				Statement stmt = con.createStatement(); 
				ResultSet courseRs = stmt.executeQuery(
					"""
						select course_name from course
						order by course_id
						"""
				);
			){
			
			StringBuilder coursrNameBuilder = new StringBuilder();
			
			while(courseRs.next())
			{
				coursrNameBuilder.append(courseRs.getString(1));
				coursrNameBuilder.append("|");
			}
			
			if(coursrNameBuilder.isEmpty())
			{
				System.out.println("\u0010[31m Error : courseTable is empty, insert course first, then student \u001B[0m");
			    return;
			}   //close try with resources
			
			
			//creating dynamic SQL with place-holders
			String insertQuery = 
					"""
					insert into student(sid,sname,course_id,fee)
					VALUES (student_sq.nextval,?,?,?)
					""";
			
			String selectCourseIdQuery = 
					"""
					select course_id from course
					where course_name = ?
				     """;
			
			//4. Create preparedStatement object with the above SQLQureies
			
			PreparedStatement insertPstmt = con.prepareStatement(insertQuery);
			PreparedStatement selectCoursePstmt = con.prepareStatement(selectCourseIdQuery);
			
			//5.Reading values for placeholder from the keyboard
			Scanner sc = new Scanner(System.in);
	        
			String choice = "N";
			
			do
			{
				System.err.println("\nEnter student name :");
				String name = sc.nextLine().trim();
				
				int course_id;
				
				while(true)
				{
					System.out.println("Enter course name :");
					String courseName = sc.nextLine();
					
					//retrieving the course_id from course table for the course name
					selectCoursePstmt.setNString(1,courseName);
					
				}
				
				
			}
			
		}
	}
}
