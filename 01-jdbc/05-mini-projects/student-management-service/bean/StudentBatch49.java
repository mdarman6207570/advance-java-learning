package com.bean;

import java.io.InputStream;

public class StudentBatch49 {
 private String student_name;
 private int student_id;
 private String student_address;
 private InputStream student_image;
   public StudentBatch49() {
	
}
public StudentBatch49(String student_name, int student_id, String student_address, InputStream student_image) {
	super();
	this.student_name = student_name;
	this.student_id = student_id;
	this.student_address = student_address;
	this.student_image = student_image;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
public String getStudent_address() {
	return student_address;
}
public void setStudent_address(String student_address) {
	this.student_address = student_address;
}
public InputStream getStudent_image() {
	return student_image;
}
public void setStudent_image(InputStream student_image) {
	this.student_image = student_image;
}
@Override
public String toString() {
	return "StudentBatch49 [student_name=" + student_name + ", student_id=" + student_id + ", student_address="
			+ student_address + ", student_image=" + student_image + "]";
}
 
 
}
