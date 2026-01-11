package com.task.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.task.bean.AdminBean;
import com.task.connect.DBConnect;

public class AdminLoginDAO {
	public AdminBean checkData(String name,String password) {
		AdminBean ab = null;
		try {
			Connection con = DBConnect.connect();
			String query = "select * from admin where uname=? and pword=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ab = new AdminBean();
				ab.setUname(rs.getString(1));
				ab.setUpass(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setLname(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setEmailid(rs.getString(6));
				ab.setPhone(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
