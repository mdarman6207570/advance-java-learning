package com.bankapp.services;

import com.bankapp.beans.Bank;

public interface BankServices 
{
	public void addCustomer(Bank bank);
	public int fetchCustomerDetails(long accNo);
	public int deleteCustomer(long accNo);
	public void deposit(double amount,long accNo);
	public void withdraw(double amount,long accNo);
	public void viewBalance(long accNo);
}
