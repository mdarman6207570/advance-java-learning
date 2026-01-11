package com.task.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.task.bean.ProductBean;
import com.task.connect.DBConnect;

public class DeleteProductDAO {
	public int deleteProduct(String pcode) {
		int row=0;
		try {
			String query="delete from product where PCODE=?";
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, pcode);
			
			row = pstmt.executeUpdate();


		}catch(Exception e) {
			e.printStackTrace();

		}
		return row;
		
	}
}
