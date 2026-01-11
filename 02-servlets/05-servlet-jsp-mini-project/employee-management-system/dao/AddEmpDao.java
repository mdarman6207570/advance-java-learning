package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmpDao 
{

	public int  insertData(EmployeeBean e)
	{
		
		String query = "INSERT INTO Employee (id, fname, lname, sal, address) VALUES (?, ?, ?, ?, ?)";

		int rowCount=0;
		try 
		{
			Connection con=DBConnect.connect();
			PreparedStatement ptsmt=con.prepareStatement(query);
			
			ptsmt.setString(1, e.getId());
			ptsmt.setString(2, e.getfName());
			ptsmt.setString(3, e.getlName());
			ptsmt.setInt(4, e.getSalary());
			ptsmt.setString(5, e.getAddress());
			rowCount=ptsmt.executeUpdate();
		} 
		catch (Exception e2) 
		{
			e2.printStackTrace();
			 System.out.println("❌ SQL Error: " + e2.getMessage());
		}
	
		return rowCount;	
	 }
	
	
}
