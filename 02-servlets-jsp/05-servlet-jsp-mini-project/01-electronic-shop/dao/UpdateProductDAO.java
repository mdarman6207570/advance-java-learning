package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO 
{
	public int updateProduct(ProductBean bean)
	{
		int rowcount = 0;
		try 
		{
			Connection con = DBConnect.connect();
			PreparedStatement ps = con.prepareStatement("UPDATE product SET pprice=?,pqty=? WHERE pcode=?");
			ps.setString(1, bean.getPprice());
			ps.setString(2, bean.getPqty());
			ps.setString(3, bean.getPcode());
			 rowcount =ps.executeUpdate();
		}
		catch (Exception e) 
		{
		   e.printStackTrace();
		}
		return rowcount;
	}
}
