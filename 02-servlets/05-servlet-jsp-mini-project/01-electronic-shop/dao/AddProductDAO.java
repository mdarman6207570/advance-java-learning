package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProductDAO 
{
	public int insertProduct(ProductBean pb)
	{
		int rowcount=0;
		
		try
		{
			Connection con = DBConnect.connect();
			PreparedStatement ps = con.prepareStatement("INSERT INTO product VALUES( ?, ?,?,?,?)");
		    ps.setString(1, pb.getPcode());
		    ps.setString(2, pb.getPname());
		    ps.setString(3, pb.getPcompany());
		    ps.setString(4, pb.getPprice());
		    ps.setString(5, pb.getPqty());
		    rowcount = ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return rowcount;
	}
}
