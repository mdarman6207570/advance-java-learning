package com.product.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.product.bean.Product;
import com.product.connection.ConnectionProvider;

public class ProductDaoImpl implements ProductDao
{
	
	@Override
	public int addProduct(Product p) 
	{
		Connection con = ConnectionProvider.getConnection();
		
	    String query = "INSERT INTO product VALUES (?, ?, ?, ?)";
	    int result = 0;

	    try 
	    {   
	             PreparedStatement pstmt = con.prepareStatement(query); 
	       
	           
	            pstmt.setInt(1, p.getId());
	            pstmt.setString(2, p.getName());
	            pstmt.setDouble(3, p.getPrice());
	            pstmt.setInt(4, p.getQuantity());

	            result = pstmt.executeUpdate();
	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}


	@Override
	public int updateProduct(Product p) 	
    {
		Connection con = ConnectionProvider.getConnection();

	    String query = "UPDATE product SET name=?, price=?, quantity=? where id=?";
	    int result = 0;

	        try
	        {
	             PreparedStatement pstmt = con.prepareStatement(query); 
	           
	            pstmt.setString(1, p.getName());
	            pstmt.setDouble(2, p.getPrice());
	            pstmt.setInt(3, p.getQuantity());
	            pstmt.setInt(4, p.getId());

	            result = pstmt.executeUpdate();
	        }
	     
	        catch (SQLException e) 
	        {
	           e.printStackTrace();
	        }

	    return result;
	}

	@Override
	public int deleteProduct(int id) 
	{
		Connection con = ConnectionProvider.getConnection();

	    String query = "DELETE FROM product WHERE id=?";
	    int result = 0;

	        try
	        {
	             PreparedStatement pstmt = con.prepareStatement(query); 
	           
	            pstmt.setInt(1,id);
	           

	            result = pstmt.executeUpdate();
	        }
	     
	        catch (SQLException e) 
	        {
	           e.printStackTrace();
	        }

	    return result;
	}

	@Override
	public int getProductById(int id) 
	{
	 	Connection con = ConnectionProvider.getConnection();
		
	    String query = "SELECT * FROM product where id=?";
	    int result = 0;

	    try 
	      {   
	    	     
	    	     PreparedStatement pstmt = con.prepareStatement(query);
	    
	           
	            ResultSet rs = pstmt.executeQuery();
	            ResultSetMetaData rsmd = rs.getMetaData();
	            
	            int columnCount = rsmd.getColumnCount();

		        System.out.println("===========================================================================");

		       
		        for (int i = 1; i <= columnCount; i++) 
		        {
		            System.out.print(rsmd.getColumnName(i) + "\t");
		        }
		        System.out.println();
		        System.out.println("...........................................................................");

	            
		        // print each row data
		        boolean found = false;
		        while (rs.next()) 
		        {
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

	            result = pstmt.executeUpdate();
	        }
	    
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }

	    return result;
	}

	@Override
	public int getAllProducts() 
	{
         Connection con = ConnectionProvider.getConnection();
		
	    String query = "SELECT * FROM product ORDER BY id";
	    int result = 0;

	    try 
	      {   
	    	     
	    	     PreparedStatement pstmt = con.prepareStatement(query);
	    
	            ResultSet rs = pstmt.executeQuery();
	            ResultSetMetaData rsmd = rs.getMetaData();
	            
	            int columnCount = rsmd.getColumnCount();

		        System.out.println("===========================================================================");

		       
		        for (int i = 1; i <= columnCount; i++) 
		        {
		            System.out.print(rsmd.getColumnName(i) + "\t");
		        }
		        System.out.println();
		        System.out.println("...........................................................................");

	            
		        // print each row data
		        boolean found = false;
		        while (rs.next()) 
		        {
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

	            result = pstmt.executeUpdate();
	      }
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	            return result; 
	      
	}
}

