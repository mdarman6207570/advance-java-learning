package com.pack1;

import java.io.Serializable;

public class ProductBean implements Serializable
{
	private String pcode,pname,pcompany,pprice,pqty;
	public ProductBean() {}
	public final String getPcode() {
		return pcode;
	}
	public final void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public final String getPname() {
		return pname;
	}
	public final void setPname(String pname) {
		this.pname = pname;
	}
	public final String getPcompany() {
		return pcompany;
	}
	public final void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}
	public final String getPprice() {
		return pprice;
	}
	public final void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public final String getPqty() {
		return pqty;
	}
	public final void setPqty(String pqty) {
		this.pqty = pqty;
	}
	
	
}
