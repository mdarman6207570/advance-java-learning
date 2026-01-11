package com.bankapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.bankapp.beans.Bank;
import com.bankapp.connection.ConnectionProvider;

public class BankServicesImple implements BankServices
{

	@Override
	public void addCustomer(Bank bank) 
	{
		Connection con = ConnectionProvider.getConnection();
		int result=0;
		
		String query = "INSERT INTO bank_account VALUES(?,?,?,?,?,?)";
		
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setLong(1, bank.getAccountNo());
			pstmt.setString(2, bank.getName());
			pstmt.setString(3, bank.getAdharNo());
			pstmt.setString(4, bank.getBankName());
			pstmt.setDouble(5, bank.getBalance());
			pstmt.setString(6, bank.getAddress());
			
			
			result = pstmt.executeUpdate();
		    if (result > 0)
		        System.out.println("✅ Customer Added Successfully!");
		    else
		        System.out.println("Insert failed.");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public int fetchCustomerDetails(long accNo) 
	{
		Connection con = ConnectionProvider.getConnection();
		int result=0;
		
		String query = "SELECT * FROM bank_account WHERE ACCOUNT_NO=?";
		
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setLong(1, accNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			/*
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("================================================================================");
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			
			System.out.println("================================================================================");			
			*/
			
			while(rs.next()) 
			{
			    
				System.out.println("================================================================================");
			    java.math.BigDecimal accNo1 = rs.getBigDecimal(1); 
			    String name = rs.getString("name");
			    String aadharNo = rs.getString(3);
			    String bankName = rs.getString("BANK_NAME");
			    double balance = rs.getDouble(5);
			    String address = rs.getString("address");
			    
			    System.out.println("Account No         : " + accNo1.toPlainString());
			    System.out.println("Account Holder Name: " + name);
			    System.out.println("Aadhar Number      : " + aadharNo);
			    System.out.println("Bank Name          : " + bankName);
			    System.out.println("Current Balance    : " + balance);
			    System.out.println("Current Address    : " + address);
			    System.out.println("================================================================================");
			}

			
			result = pstmt.executeUpdate();
		}   
		catch (SQLException e) 
		{
			System.out.println("Wrong Data!!!");
		}
		
		return result;
	}

	@Override
	public int deleteCustomer(long accNo) 
	{
		Connection con = ConnectionProvider.getConnection();
         int result=0;
		
		String query = "DELETE FROM bank_account WHERE ACCOUNT_NO=?";
		
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setLong(1, accNo);
			
			result = pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		 return result; 
	}

	@Override
	public void deposit(double amount, long accNo) 
	{
      Connection con = ConnectionProvider.getConnection();
        
		String query = "UPDATE bank_account Set balance=balance+? WHERE ACCOUNT_NO=?";
		
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(query);
			
			if(amount>0) 
			{
				pstmt.setDouble(1, amount);
				pstmt.setLong(2, accNo);
			}
			else
			{
				System.err.println("Invalid Amount!!!");
			}
			
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			System.out.println("Amount Deposited Successful!!!");
			else
				System.err.println("Invalid Account Number!!!");
		}
		catch (SQLException e) 
		{
			System.err.println("Invalid Amount!!!");
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(double amount, long accNo) 
	{
        Connection con = ConnectionProvider.getConnection();
        
		String query = "UPDATE bank_account Set balance=balance-? WHERE ACCOUNT_NO=?";
		String query2 = "select BALANCE FROM bank_account WHERE ACCOUNT_NO=?";
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(query);
			PreparedStatement currBalpst = con.prepareStatement(query2);
			
			currBalpst.setLong(1, accNo);
			
			ResultSet currbal = currBalpst.executeQuery();
			
			double balance=0;
			while(currbal.next())
			{
				balance = currbal.getDouble("balance");
			}
			
			
			if(amount<=balance) 
			{
				pstmt.setDouble(1, amount);
				pstmt.setLong(2, accNo);
			}
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			System.out.println("Amount Withdraw Successful!!!");
			else
				System.err.println("Invalid Account Number!!!");
		}
		catch (SQLException e) 
		{
			System.err.println("Invalid Amount!!!");
		}
	}

	@Override
	public void viewBalance(long accNo) 
	{
		Connection con = ConnectionProvider.getConnection();
        
		
		String query = "select BALANCE FROM bank_account WHERE ACCOUNT_NO=?";
		
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setLong(1, accNo);
			ResultSet rs = pstmt.executeQuery();
			
			double balance =0;
			while(rs.next())
			{
				balance = rs.getDouble("balance");
			}
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			System.out.println("Account Current balance is :"+balance);
			else
				System.err.println("Invalid Account Number!!!");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
