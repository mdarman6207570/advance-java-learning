package com.nit.hk.jdbc;

public class Addition 
{
	public static void main(String[] args) 
	{
	   int a = 10;
	   int b = 20;
	   int c = a+b;
	   
	   System.out.println("The addition of "+a+" and "+b+" is "+c);
	   
	   System.out.printf("The addition of %d and %d is %d", a,b,c);
	   System.out.println();
	   
	   System.out.printf("The addition of %5d and %-20d is %d", a,b,c);
	}

}
