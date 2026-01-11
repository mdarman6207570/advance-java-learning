package com.task.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.task.beans.Employee;

public class EmployeeService implements IEmployeeOperation {
    private static String driverName="oracle.jdbc.driver.OracleDriver";
    private static String url="jdbc:oracle:thin:@localhost:1521:xe";
    private static String username="system";
    private static String password="manager";
    
	@Override
	public void fetchData() {
		 String query="select * from EmployeeBatch49";
		 try {
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt=con.prepareStatement(query);
			
			    ResultSet rs = pstmt.executeQuery();
			    
			    while(rs.next()) {
			    	  System.out.println("Name of the employee "+rs.getString(1));
			    	  System.out.println("Id of the employee "+rs.getInt(2));
			    	  System.out.println("Salary of the employee "+rs.getDouble(3));
			    }
			    
			    
			    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		  

	}

	@Override
	public int addData(Employee emp) {
		  String query="insert into EmployeeBatch49 values(?,?,?)";
		  int result=0;
		 try {
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, emp.getEmp_Name());
			pstmt.setInt(2, emp.getEmp_id());
			pstmt.setDouble(3, emp.getEmp_salary());
			
			   result = pstmt.executeUpdate();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public int updateData(int id, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
