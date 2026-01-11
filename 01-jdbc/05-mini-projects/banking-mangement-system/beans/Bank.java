package com.bankapp.beans;

public class Bank 
{
	private long accountNo;
	private String name;
	private String adharNo;
	private String bankName;
	private double balance;
	private String address;
	
	public Bank(long accountNo, String name, String adharNo, String bankName, double balance, String address) 
	{
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.adharNo = adharNo;
		this.bankName = bankName;
		this.balance = balance;
		this.address = address;
	}

	
	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() 
	{
		return "Bank [accountNo=" + accountNo + ", name=" + name + ", adharNo=" + adharNo + ", bankName=" + bankName
				+ ", balance=" + balance + ", address=" + address + "]";
	}
	
	

}
