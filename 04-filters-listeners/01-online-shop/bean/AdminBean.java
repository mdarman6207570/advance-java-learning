package com.task.bean;

import java.io.Serializable;

public class AdminBean implements Serializable {
	private String uname,upass,fname,lname,addr,emailid,phone;
	public AdminBean() {}
	public final String getUname() {
		return uname;
	}
	public final void setUname(String uname) {
		this.uname = uname;
	}
	public final String getUpass() {
		return upass;
	}
	public final void setUpass(String upass) {
		this.upass = upass;
	}
	public final String getFname() {
		return fname;
	}
	public final void setFname(String fname) {
		this.fname = fname;
	}
	public final String getLname() {
		return lname;
	}
	public final void setLname(String lname) {
		this.lname = lname;
	}
	public final String getAddr() {
		return addr;
	}
	public final void setAddr(String addr) {
		this.addr = addr;
	}
	public final String getEmailid() {
		return emailid;
	}
	public final void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public final String getPhone() {
		return phone;
	}
	public final void setPhone(String phone) {
		this.phone = phone;
	}
	
}
