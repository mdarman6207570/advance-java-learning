package com.nit.user;

import java.util.Scanner;

import com.nit.beans.Employee;
import com.nit.services.EmployeeService;


public class EmployeeDataOperation {
public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 Employee e = null;
	 EmployeeService service=new EmployeeService();
	  
	 while(true) 
	 {
		   System.out.println("\u001B[31m"+"Press 1 for getting the Data");
		   System.out.println("\u001B[32m"+"Press 2 for adding the Data");
		   System.out.println("\u001B[33m"+"Press 3 for updating the Data");
		   System.out.println("\u001B[34m"+"Press 4 for delete the Data");
		   System.out.println("\u001B[35m"+"Press 5 for exit");
		   System.out.println("\u001B[0m"+"Enter your choice");
		   int choice=sc.nextInt();
		   
		  switch(choice) 
	      {
		     case 1 ->
		     {
		    	       service.fetchData();
		     }      
		    	
		     case 2 ->
		     {
		        System.out.println("Enter the id :");
		    	    int id=sc.nextInt();
		    	    System.out.println("Enter the name of the employee :");
		    	    String name=sc.next();
		    	    System.out.println("Enter the salary :");
		    	    double salary=sc.nextDouble();
		    	    System.out.println("Enter the name of the department :");
		    	    String department=sc.next();
		    	    
		    	    e=new Employee(id,name,salary,department);// 2000x[ name,id,salary]
		    	    
		    	        int data = service.addData(e);
		    	        
		    	         if(data>=1) 
		    	         {
		    	        	  System.out.println("Data Stored!!");
		    	         }
		    	         else {
		    	        	  System.out.println("Data not stored!!");
		    	         }
		    	    
		     }
		     case 3 ->
		     {
		    	   System.out.println("Enter Employee Id :");
		    	   int id = sc.nextInt();
		    	   service.deleteData(id);
		     }
		    	 
		     case 4 ->
		     {
		    	   System.out.println("Enter Employee Id :");
		    	   int id = sc.nextInt();
		    	   System.out.println("Enter Employee New Name :");
		    	   String name = sc.next();
		    	   service.updateData(id, name);
		     }
		
		     case 5 ->
		     {
		    	    System.out.println("Thanx for using the App");
		    	    System.exit(0);
		     }
		    	 default ->
		    	 {
		    		 System.err.println("Invalid input");
		    		System.exit(0);
		     } 
	    }
    }
	  
	  
	  
  }
}

