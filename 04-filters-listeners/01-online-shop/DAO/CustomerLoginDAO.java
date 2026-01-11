package com.task.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.task.bean.AdminBean;
import com.task.bean.CustomerBean;
import com.task.connect.DBConnect;

public class CustomerLoginDAO {

	public CustomerBean checkData(String name, String password) {
		CustomerBean cb = null;
		try {
			Connection con = DBConnect.connect();
			String query = "select * from customer where uname=? and pword=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cb = new CustomerBean();
				cb.setUserName(rs.getString(1));
				cb.setPassword(rs.getString(2));
				cb.setFirstName(rs.getString(3));
				cb.setLastName(rs.getString(4));
				cb.setAddress(rs.getString(5));
				cb.setMailid(rs.getString(6));
				cb.setMobile(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}

}
