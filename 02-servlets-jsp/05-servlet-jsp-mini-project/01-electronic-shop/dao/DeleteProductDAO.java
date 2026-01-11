package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProductDAO
{
	public int deleteProduct(String pcode)
	{
		int rowcount =0;
		try
		{
			Connection con = DBConnect.connect();
			PreparedStatement ps = con.prepareStatement("delete from product WHERE pcode=?");
			ps.setString(1, pcode);
			
			rowcount=ps.executeUpdate();
		}
		catch (SQLException e) 
		{
		   e.printStackTrace();
		}
		return rowcount;
	}
}
