package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewEmpDAO 
{

	
  public ArrayList<EmployeeBean> al = new  ArrayList<EmployeeBean>();
  
  
  public ArrayList<EmployeeBean> retrieve()
  {
	  
	  
	  try {
		    Connection con= DBConnect.connect();
		    PreparedStatement ptsmt=con.prepareStatement("Select * from Employee");
		    ResultSet rs =     ptsmt.executeQuery();
		    
		    while(rs.next())
		    {
		    	
		    	EmployeeBean bean = new EmployeeBean();
		    	
		    	bean.setId(rs.getString(1));
		    	bean.setfName(rs.getString(2));
		    	bean.setlName(rs.getString(3));
		    	bean.setSalary(rs.getInt(4));
		    	bean.setAddress(rs.getString(5));
		    	
		    	al.add(bean);
		    	 	
		    }
	    } 
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	   
	  return al;
 	  
     }
 }
