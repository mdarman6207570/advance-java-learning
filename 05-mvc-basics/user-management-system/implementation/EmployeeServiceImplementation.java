package com.implementation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.EmployeeBean;
import com.connection_provider.DBConnect;

public class EmployeeServiceImplementation 
{
	
	public int insert(EmployeeBean eb)
	{
		int rowcount = 0;
		try
		{
			String query = "INSERT INTO user_table VALUES (?,?,?)";
			Connection con = DBConnect.con;
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, eb.getId());
			pstmt.setString(2, eb.getName());
			pstmt.setString(3, eb.getAadhaar());
			
			rowcount = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowcount;
	}
	
	public ArrayList<EmployeeBean> select()
	{
	    ArrayList<EmployeeBean> al = new ArrayList<>();

	    try 
	    {
	        String query = "SELECT * FROM user_table";
	        Connection con = DBConnect.con;
	        PreparedStatement pstmt = con.prepareStatement(query);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) 
	        {
	            EmployeeBean eb = new EmployeeBean();
	            eb.setId(rs.getInt(1));
	            eb.setName(rs.getString(2));
	            eb.setAadhaar(rs.getString(3));
	            al.add(eb); 
	        }
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }

	    return al;
	}

	
	public int update(EmployeeBean eb)
	{
		int rowcount=0;
		try 
		{
	        String query = "UPDATE user_table SET name=?,aadhar=? WHERE id=?";
	        Connection con = DBConnect.con;
	        PreparedStatement pstmt = con.prepareStatement(query);
	
	        pstmt.setString(1, eb.getName());
	        pstmt.setString(2, eb.getAadhaar());
	        pstmt.setInt(3, eb.getId());
	        
	        rowcount=pstmt.executeUpdate();
	        
	    }
		catch (Exception e) 
		{
	        e.printStackTrace();
	    }
       
		return rowcount;
	}
	
	public int delete(EmployeeBean eb)
	{
		int rowcount=0;
		try 
		{
	        String query = "DELETE FROM user_table WHERE id=?";
	        Connection con = DBConnect.con;
	        PreparedStatement pstmt = con.prepareStatement(query);
	
	        pstmt.setInt(1, eb.getId());
	        
	        rowcount=pstmt.executeUpdate();
	        
	    }
		catch (Exception e) 
		{
	        e.printStackTrace();
	    }
       
		return rowcount;
	}
}
