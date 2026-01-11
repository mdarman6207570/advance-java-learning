package com.task.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.task.bean.ProductBean;
import com.task.connect.DBConnect;

public class UpdateCustomerProductDAO {

	public int updateProduct(ProductBean bean, int reqNo) {

		int row = 0;

		String query = "update product set PNAME = ?,PCOMPANY =?,PPRICE =?, PQTY = PQTY - ? where PCODE = ?";

		Connection con = DBConnect.connect();
		try (PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setString(1, bean.getpName());
			pstmt.setString(2, bean.getpCompany());
			pstmt.setInt(3, bean.getpPrice());
			pstmt.setInt(4, reqNo);
			pstmt.setString(5, bean.getpCode());

			row = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return row;
	}

	public boolean checkItems(ProductBean bean, int reqNo) {

		int qty = 0;

		String query = "select PQTY from product where PCODE = ?";

		Connection con = DBConnect.connect();
		try (PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setString(1, bean.getpCode());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				qty = rs.getInt(1);
			} else {
				throw new RuntimeException("Technical Issue");

			}

			if (reqNo <= qty) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
