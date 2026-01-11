package com.pack1;

import java.io.Serializable;

public class AdminBean implements Serializable 
{
	private String a_uname,a_pwd,a_fname,a_lname,a_addr,a_mid,a_phno;
	
	public AdminBean() {}

	public final String getA_uname() {
		return a_uname;
	}

	public final void setA_uname(String a_uname) {
		this.a_uname = a_uname;
	}

	public final String getA_pwd() {
		return a_pwd;
	}

	public final void setA_pwd(String a_pwd) {
		this.a_pwd = a_pwd;
	}

	public final String getA_fname() {
		return a_fname;
	}

	public final void setA_fname(String a_fname) {
		this.a_fname = a_fname;
	}

	public final String getA_lname() {
		return a_lname;
	}

	public final void setA_lname(String a_lname) {
		this.a_lname = a_lname;
	}

	public final String getA_addr() {
		return a_addr;
	}

	public final void setA_addr(String a_addr) {
		this.a_addr = a_addr;
	}

	public final String getA_mid() {
		return a_mid;
	}

	public final void setA_mid(String a_mid) {
		this.a_mid = a_mid;
	}

	public final String getA_phno() {
		return a_phno;
	}

	public final void setA_phno(String a_phno) {
		this.a_phno = a_phno;
	}
	
	
}
