package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO 
{
	public int updateData(UserBean ub)
	{
		int rowcount = 0;
		try 
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("UPDATE registration SET firstname=?, lastname=?,mailid=?, phone=? WHERE username=?");
		     
			pstmt.setString(1, ub.getU_fname());
			pstmt.setString(2, ub.getU_lname());
			pstmt.setString(3, ub.getU_mail());
			pstmt.setString(4, ub.getU_phone());
			pstmt.setString(5, ub.getU_name());
			
			rowcount = pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return rowcount;
	}
}
