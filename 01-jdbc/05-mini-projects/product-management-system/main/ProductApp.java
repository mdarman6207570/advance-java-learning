package com.product.main;

import java.util.Scanner;

import com.product.bean.Product;
import com.product.service.ProductDaoImpl;


public class ProductApp {

	public static void main(String[] args) 
	{
		System.out.println("===== PRODUCT MANAGEMENT SYSTEM =====");
		System.out.println("1. Add Product");
		System.out.println("2. View Product by ID");
		System.out.println("3. View All Products");
		System.out.println("4. Update Product");
		System.out.println("5. Delete Product");
		System.out.println("6. Exit");
		
		Product product = null;
	    ProductDaoImpl pdi = new ProductDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		
		  switch(choice) 
	      {
		     case 1 ->
		     {
		    	    System.out.println("Enter the id :");
		    	    int id=sc.nextInt();
		    	    System.out.println("Enter the name of the product :");
		    	    String name=sc.next();
		    	    System.out.println("Enter the product price :");
		    	    double price=sc.nextDouble();
		    	    System.out.println("Enter the quantity of the product :");
		    	    int quantity = sc.nextInt();
		    	   
		    	    product = new Product(id,name,price,quantity);
		    	       
		    	       int data = pdi.addProduct(product);
		    	        
		    	         if(data>=1) 
		    	         {
		    	        	  System.out.println("Data Stored!!");
		    	         }
		    	         else {
		    	        	  System.out.println("Data not stored!!");
		    	         }
		    	    
		     }      
		    	
		     
		     case 2 ->
		     {
		       
		    	 System.out.println("Enter the id :");
		    	    int id=sc.nextInt();
		    	    
		    	    int data = pdi.getProductById(id);
	    	        
	    	         if(data ==0) 
	    	        	  System.out.println("No Data Found!!!");
	    	             
		     }
		     
		     
		     case 3 ->
		     {
		    	 int data = pdi.getAllProducts();
	    	        
    	         if(data>=1) 
    	         {
    	        	  System.out.println("Data Stored!!");
    	         }
    	         else {
    	        	  System.out.println("Data not stored!!");
    	         }
		     }
		    	 
		     case 4 ->
		     {
		     	 System.out.println("Enter the id :");
		    	    int id=sc.nextInt();
		    	    System.out.println("Enter the name of the product :");
		    	    String name=sc.next();
		    	    System.out.println("Enter the product price :");
		    	    double price=sc.nextDouble();
		    	    System.out.println("Enter the quantity of the product :");
		    	    int quantity = sc.nextInt();
		    	   
		    	    product = new Product(id,name,price,quantity);
		    	   int data = pdi.updateProduct(product);
		    	   
		    	   if(data ==0) 
	    	        	  System.out.println("No Data updated!!!");
	    	         else
	    	        	 System.out.println(data+" Product updated!!1");
		     }
		
		     case 5 ->
		     {
		    	    System.out.println("Enter the id :");
		    	    int id=sc.nextInt();
		    	    
		    	    int data = pdi.deleteProduct(id);
	    	        
	    	         if(data ==0) 
	    	        	  System.out.println("No Data Found!!!");
	    	         else
	    	        	 System.err.println("Product is Deleted!!!");
	    	        
		     }
		     
		     case 6 ->
		     {
		    	   System.err.println("Thank You Visit Again!!!");
		    	   System.exit(0);
		     }
		     
		    	 default ->
		    	 {
		    		 System.err.println("Invalid input");
		    		System.exit(0);
		     } 
	    }
	   sc.close(); 
	    
   }
}
