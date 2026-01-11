package com.task.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.task.bean.ProductBean;
import com.task.connect.DBConnect;

public class AddProductDAO {
	public int insertProduct(ProductBean pbean) {
		String query = "insert into product values(?,?,?,?,?)";
		int row = 0;
		Connection con = DBConnect.connect();
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, pbean.getpCode());
			pstmt.setString(2, pbean.getpName());
			pstmt.setString(3, pbean.getpCompany());
			pstmt.setInt(4, pbean.getpPrice());
			pstmt.setInt(5, pbean.getpQty());
			
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
}
