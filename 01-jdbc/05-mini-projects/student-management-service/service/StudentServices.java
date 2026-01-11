package com.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.StudentBatch49;
import com.connection.ConnectionProvider;

public class StudentServices implements IStudentService {

	@Override
	public void getData() {
		String query="select * from StudentBatch49";
		
		Connection con=ConnectionProvider.getConnection();
		
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			File file=new File
					("D:\\IMAGE\\ll.jpg");
			FileOutputStream fos=new FileOutputStream(file);
			
			while(rs.next()) {
				 System.out.println("Name of the studnet :"+rs.getString(1));
				 System.out.println("Id of the studnet :"+rs.getInt(2));
				 System.out.println("Address of the studnet :"+rs.getString(3));
				     InputStream binaryStream = rs.getBinaryStream(4);
				     
				           byte[] allBytes = binaryStream.readAllBytes();
				            
				              fos.write(allBytes);
				              
				              System.out.println("All data stored in file location");
				              
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public int insertData(StudentBatch49 ref) {
		  String query="insert into StudentBatch49 values(?,?,?,?)";
		  Connection con=ConnectionProvider.getConnection();
		  int result=0;
		     try {
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, ref.getStudent_name());
				pstmt.setInt(2, ref.getStudent_id());
				pstmt.setString(3, ref.getStudent_address());
				pstmt.setBinaryStream(4, ref.getStudent_image());
				
				result=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		     return result;
	}

	@Override
	public int deleteData(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateData(int id) {
		String query="update StudentBatch49 set student_image=? where student_id=?";
		Connection con=ConnectionProvider.getConnection();
		int result=0;
		
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			File file=new File("D:\\IMAGE\\aa.jpg");
			FileInputStream fis=new FileInputStream(file);
			
			pstmt.setBinaryStream(1, fis);
			pstmt.setInt(2, id);
			 
			     result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
}
