package com.task.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.task.bean.CustomerBean;
import com.task.connect.DBConnect;

public class CustomerRegisterDAO {
	public int insertData(CustomerBean cb) {
		String query = "insert into customer values(?,?,?,?,?,?,?)";
		int row = 0;
		Connection con = DBConnect.connect();
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1,cb.getUserName());
			pstmt.setString(2,cb.getPassword() );
			pstmt.setString(3,cb.getFirstName() );
			pstmt.setString(4,cb.getLastName());
			pstmt.setString(5,cb.getAddress() );
			pstmt.setString(6,cb.getMailid() );
			pstmt.setString(7,cb.getMobile() );

			
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
}
