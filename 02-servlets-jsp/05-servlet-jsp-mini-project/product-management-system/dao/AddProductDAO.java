package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO 
{
	public int insert(ProductBean p)
	{
		String query = "INSERT INTO product VALUES (?,?,?,?,?)";
		int rowCount=0;
		
		try 
		{
			Connection con = DBConnect.connect();	
			PreparedStatement pstmt = con.prepareStatement(query);	
		
			pstmt.setString(1, p.getPcode());
			pstmt.setString(2, p.getPname());
			pstmt.setString(3, p.getPcompany());
			pstmt.setString(4, p.getPprice());
			pstmt.setString(5, p.getPqty());
			
			rowCount = pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			 System.out.println("❌ SQL Error: " + e.getMessage());
		}
		
		return rowCount;
	}
	
}
