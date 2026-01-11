package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewProductDAO 
{
	public ArrayList<ProductBean> al = new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> retrieve()
	{
		try
		{
          Connection con = DBConnect.connect();
          PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product");
          ResultSet rs = pstmt.executeQuery();
          
          while(rs.next())
          {
        	  ProductBean pb = new ProductBean();
        	  
        	  pb.setPcode(rs.getString(1));
        	  pb.setPname(rs.getString(2));
        	  pb.setPcompany(rs.getString(3));
        	  pb.setPprice(rs.getString(4));
        	  pb.setPqty(rs.getString(5));
        	  
        	  al.add(pb);
          }
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
	   }
		
		return al;
	}
}
