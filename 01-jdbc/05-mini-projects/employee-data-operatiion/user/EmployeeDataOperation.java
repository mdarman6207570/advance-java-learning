package com.task.user;

import java.util.Scanner;

import com.task.beans.Employee;
import com.task.services.EmployeeService;

public class EmployeeDataOperation {
public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 Employee e=new Employee();
	 EmployeeService service=new EmployeeService();
	  while(true) {
		   System.out.println("\u001B[31m"+"Press 1 for getting the Data");
		   System.out.println("\u001B[32m"+"Press 2 for adding the Data");
		   System.out.println("\u001B[33m"+"Press 3 for updating the Data");
		   System.out.println("\u001B[34m"+"Press 4 for delete the Data");
		   System.out.println("\u001B[35m"+"Press 5 for exit");
		   System.out.println("\u001B[0m"+"Enter your choice");
		   int choice=sc.nextInt();
		   
		     switch(choice) {
		     case 1:
		    	       service.fetchData();
		    	 break;
		     case 2:
		    	    System.out.println("Enter the name of the employee");
		    	    String name=sc.next();
		    	    System.out.println("Enter the id ");
		    	    int id=sc.nextInt();
		    	    System.out.println("Enter the salary");
		    	    double salary=sc.nextDouble();
		    	    e=new Employee(name, id, salary);// 2000x[ name,id,salary]
		    	    
		    	        int data = service.addData(e);
		    	        
		    	         if(data>=1) {
		    	        	  System.out.println("Data Stored!!");
		    	         }
		    	         else {
		    	        	  System.out.println("Data not stored!!");
		    	         }
		    	    
		    	 break;
		     case 3:
		    	 break;
		     case 4:
		    	 break;
		     case 5:
		    	    System.out.println("Thankx for using the App");
		    	    System.exit(0);
		    	 
		    	 default:
		    		 System.out.println("Invalid input");
		    		 break;
		     }
		  
		   
	  }
}
}
