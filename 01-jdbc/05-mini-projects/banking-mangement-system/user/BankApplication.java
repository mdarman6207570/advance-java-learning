package com.bankapp.user;

import java.util.Scanner;

import com.bankapp.beans.Bank;
import com.bankapp.services.BankServicesImple;

public class BankApplication {

	public static void main(String[] args) 
	{
		BankServicesImple bservice = new BankServicesImple();
		Scanner sc = new Scanner(System.in);

		 // ANSI escape codes for colors
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String pink = "\u001B[35m";
        String lblue = "\u001B[36m";
        String white = "\u001B[37m";
       
		
		
		
		while(true)
		{

		System.out.println(lblue+"1. Add Customer"+reset);
		System.out.println(green+"2. Fetch Customer Details"+reset);
		System.out.println(yellow+"3. Delete Customer"+reset);
		System.out.println(blue+"4. Deposit Amount"+reset);
		System.out.println(pink+"5. Withdraw Amount"+reset);
		System.out.println(white+"6. View Balance"+reset);
		System.out.println(red+"7. Exit"+reset);
		
		
		Bank bank = null;
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		   case 1 ->
	       {
			System.out.println("Enter Account number :");
			long acno = sc.nextLong();
			System.out.println("Enter Name :");
			String name = sc.next();
			System.out.println("Enter Aadhar Number :");
			String aadharNo = sc.next();
			System.out.println("Enter Bank Name :");
			String bankName = sc.next();
			System.out.println("Enter Account Balance :");
			double balance = sc.nextDouble();
			System.out.println("Enter Address :");
			String address = sc.next();
			
			bank = new Bank(acno, name, aadharNo, bankName, balance, address);
			
			bservice.addCustomer(bank);
		   }
	       
		   case 2 ->
	       {
	    	      System.out.println("Enter Account number :");
		      long acno = sc.nextLong();
		      int result = bservice.fetchCustomerDetails(acno);
		      
		      if (result > 0)
			        System.out.println("Record Fetched successfully!!!");
		      else
		      {
		    	       System.out.println("Account Not Exist!!!");
		      }
			
		   }
	       
		   case 3 ->
	       {
	    	     System.out.println("Enter Account number :");
				long acno = sc.nextLong();
	    	   
	    	     int result = bservice.deleteCustomer(acno);
	    	   
	    	        if (result > 0)
			        System.out.println("✅ Customer Deleted Successfully!");
			    else
			        System.out.println("Deletion failed.");
		   }
	       
		   case 4 ->
	       {
	    	       System.out.println("Enter Account number :");
				long acno = sc.nextLong();
				System.out.println("Enter Amount :");
				double balance = sc.nextDouble();
				
				bservice.deposit(balance, acno);
		   }
	       
		   case 5 ->
	       {
	    	        System.out.println("Enter Account number :");
				long acno = sc.nextLong();
				System.out.println("Enter Withdraw Amount :");
				double amount = sc.nextDouble();
				
				bservice.withdraw(amount, acno);
		   }
	       
		   case 6 ->
	       {
	    	      System.out.println("Enter Account number :");
		     	long acno = sc.nextLong();
		     	
		     	bservice.viewBalance(acno);
		   }
	       
		   case 7 ->
	       {
			  System.out.println("Thank u Visit Again!!!");
			  sc.close();
			  System.exit(0);
		   }
	       
		   default ->
	       {
			 System.err.println("Invalid Option!!!");
			 System.exit(0);
		   }
		}
		 }
		
		
	}
}
