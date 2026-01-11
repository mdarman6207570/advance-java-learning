package com.task.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.task.bean.ProductBean;
import com.task.connect.DBConnect;

public class ViewProductDAO {
	ArrayList<ProductBean> al = new ArrayList<ProductBean>();
	public ArrayList<ProductBean>  viewProducts(){
		try {
			Connection con = DBConnect.connect();
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setpCode(rs.getString(1));
				pb.setpName(rs.getString(2));
				pb.setpCompany(rs.getString(3));
				pb.setpPrice(rs.getInt(4));
				pb.setpQty(rs.getInt(5));
				
				al.add(pb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
