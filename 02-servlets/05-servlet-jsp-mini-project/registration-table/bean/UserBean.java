package com.pack1;

import java.io.Serializable;

public class UserBean implements Serializable
{
	private String u_name,u_password,u_fname,u_lname,u_mail,u_phone;
	
	public UserBean() {}


	public final String getU_name() {
		return u_name;
	}

	public final void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public final String getU_password() {
		return u_password;
	}

	public final void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public final String getU_fname() {
		return u_fname;
	}

	public final void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}

	public final String getU_lname() {
		return u_lname;
	}

	public final void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}

	public final String getU_mail() {
		return u_mail;
	}

	public final void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}

	public final String getU_phone() {
		return u_phone;
	}

	public final void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	
	
	
}
