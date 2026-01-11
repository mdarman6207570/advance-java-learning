package com.task.beans;

public class Employee {
  private String emp_Name;
  private int emp_id;
  private double emp_salary;
    public Employee(){
    	 
    }
public Employee(String emp_Name, int emp_id, double emp_salary) {
	super();
	this.emp_Name = emp_Name;
	this.emp_id = emp_id;
	this.emp_salary = emp_salary;
}
public String getEmp_Name() {
	return emp_Name;
}
public void setEmp_Name(String emp_Name) {
	this.emp_Name = emp_Name;
}
public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public double getEmp_salary() {
	return emp_salary;
}
public void setEmp_salary(double emp_salary) {
	this.emp_salary = emp_salary;
}
@Override
public String toString() {
	return "Employee [emp_Name=" + emp_Name + ", emp_id=" + emp_id + ", emp_salary=" + emp_salary + "]";
}
  
  
 
}
