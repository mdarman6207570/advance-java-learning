package com.pack1;

public class ProductBean 
{
	private String pcode;
	private String pname;
	private String pcompany;
	private String pprice;
	private String pqty;
	
	public ProductBean() 
	{
		
	}
	
	public ProductBean(String pcode, String pname, String pcompany, String pprice, String pqty) 
	{
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.pcompany = pcompany;
		this.pprice = pprice;
		this.pqty = pqty;
	}

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