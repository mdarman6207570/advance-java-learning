package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProductDAO 
{
	ArrayList<ProductBean> al = new  ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> viewProducts()
	{
		try
		{
			Connection con = DBConnect.connect();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM product");
			ResultSet rs = ps.executeQuery();
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
		catch (Exception e) 
		{
		   e.printStackTrace();
		}
		return al;
	}
}
