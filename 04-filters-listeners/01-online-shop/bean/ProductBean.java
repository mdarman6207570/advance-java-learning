package com.task.bean;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private String pCode;
	private String pName;
	private String pCompany;
	private int pPrice;
	private int pQty;
	public ProductBean() {
		super();
	}
	public ProductBean(String pCode, String pName, String pCompany, int pPrice, int pQty) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pCompany = pCompany;
		this.pPrice = pPrice;
		this.pQty = pQty;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCompany() {
		return pCompany;
	}
	public void setpCompany(String pCompany) {
		this.pCompany = pCompany;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpQty() {
		return pQty;
	}
	public void setpQty(int pQty) {
		this.pQty = pQty;
	}
	@Override
	public String toString() {
		return "ProductBean [pCode=" + pCode + ", pName=" + pName + ", pCompany=" + pCompany + ", pPrice=" + pPrice
				+ ", pQty=" + pQty + "]";
	}
	
	

}
