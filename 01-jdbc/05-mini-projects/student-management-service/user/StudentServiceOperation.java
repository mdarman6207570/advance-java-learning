package com.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.StudentBatch49;
import com.connection.ConnectionProvider;
import com.service.StudentServices;


public class StudentServiceOperation {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	StudentServices services=new StudentServices();
	StudentBatch49 student=new StudentBatch49();
	
	  while(true) {
		   System.out.println("\u001B[31m"+"Press 1 view the data");
		   System.out.println("\u001B[32m"+"Press 2 add the data");
		   System.out.println("\u001B[33m"+"Press 3 delete the data");
		   System.out.println("\u001B[34m"+"Press 4 update the data");
		   System.out.println("\u001B[35m"+"Press 5 exit the data");
		   System.out.println("\u001B[0m"+"Enter your choice");
		    
		   int choice=sc.nextInt();
		   
		    switch(choice) 
		    {
		    case 1:
		    	     System.out.println("Wait for while ");
		    	     System.out.println("We are getting the data for you.....");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   services.getData();
		    	break;
		    case 2:
		    	System.out.println("Enter the student name");
		    	String name=sc.next();
		    	System.out.println("Enter the student id");
		    	int id=sc.nextInt();
		    	System.out.println("Enter the student address");
		    	String address=sc.next();
		    	
		    	File file=new File
		   ("D:\\IMAGE\\aa.jpg");//D:\IMAGE
		    	try {
					FileInputStream fis=new FileInputStream(file);
					student=new StudentBatch49
							(name, id, address, fis);
					
					   int insertData = services.insertData(student);
					   
					   if(insertData>=1) {
						    System.out.println("Data Inserted!!");
					   }
					   else {
						    System.out.println("Data not inserted!!");
					   }
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	break;
		    case 3:
		    	break;
		    case 4:
		    	     System.out.println("Enter the id for changing the image");
		    	     int existId=sc.nextInt();
		    	     
		    	     int updateData = services.updateData(existId);
		    	     
		    	     if(updateData>=1) {
		    	    	  System.out.println("Image updated");
		    	     }
		    	     else {
		    	    	  System.err.println("Image not updated");
		    	     }
		    	     
		    	break;
		    case 5:
		    	System.out.println("Thanks for using the application");
		    	Connection con=ConnectionProvider.getConnection();
		    	try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	System.exit(0);
		    	default:
		    		System.out.println("Invalid input");
		    		break;
		    }
		   
	  }
}
}

