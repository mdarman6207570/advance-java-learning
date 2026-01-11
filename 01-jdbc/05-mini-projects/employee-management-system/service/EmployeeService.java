package com.nit.services;

import com.nit.beans.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;




public class EmployeeService implements IEmployeeOperation 
{
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String username = "arman";
	private static String password = "rohan";

	@Override
	public void fetchData() 
	{
	    String query = "select * from Employee order by id";
	    
	    try(Connection con = DriverManager.getConnection(url, username, password);
		        PreparedStatement pstmt = con.prepareStatement(query);
	    		ResultSet rs = pstmt.executeQuery();
	    		)
	    {
	        Class.forName(driverName);
	        ResultSetMetaData rsmd = rs.getMetaData();

	        int columnCount = rsmd.getColumnCount();

	        System.out.println("===========================================================================");

	       
	        for (int i = 1; i <= columnCount; i++) {
	            System.out.print(rsmd.getColumnName(i) + "\t");
	        }
	        System.out.println();
	        System.out.println("...........................................................................");

	        // print each row data
	        boolean found = false;
	        while (rs.next()) {
	            found = true;
	            for (int i = 1; i <= columnCount; i++) {
	                System.out.print(rs.getString(i) + "\t");
	            }
	            System.out.println();
	        }

	        if (!found) {
	            System.err.println("No Data Available!!!");
	        }

	        System.out.println("===========================================================================");

	        // cleanup
//	        rs.close();
//	        pstmt.close();
//	        con.close();

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public int addData(Employee emp) 
	{
		String query = "insert into Employee values(?,?,?,?)";
		int result = 0;
		
		try(Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(query);
		   ) 
		{
			Class.forName(driverName);
			

			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());
			pstmt.setString(4, emp.getDepartment());

			result = pstmt.executeUpdate();

		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return result;
		
	}

	@Override
	public int deleteData(int id) 
	{
		String query = "delete from Employee where id="+id;
		int result = 0;
		
		try(Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(query);
				) 
		{
			Class.forName(driverName);
			

			System.out.println(id+" :Id number Employee Deleted Successfully!!!");

			result = pstmt.executeUpdate();

		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int updateData(int id, String name) {
	    String query = "UPDATE Employee SET name = ? WHERE id = ?";
	    int result = 0;

	    try {
	        Class.forName(driverName);
	        Connection con = DriverManager.getConnection(url, username, password);
	        PreparedStatement pstmt = con.prepareStatement(query);

	       
	        pstmt.setString(1, name);
	        pstmt.setInt(2, id);

	        result = pstmt.executeUpdate();

	        if (result > 0) {
	            System.out.println(id + " : Employee Name updated with new Name: " + name);
	        } else {
	            System.out.println("No employee found with id: " + id);
	        }

	        
	        pstmt.close();
	        con.close();

	    }
	    catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}


}
