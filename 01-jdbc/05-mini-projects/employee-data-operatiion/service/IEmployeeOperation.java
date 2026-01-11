package com.task.services;

import com.task.beans.Employee;

public interface IEmployeeOperation {
     public void fetchData();
     public int addData(Employee emp);
     public int deleteData(int id);
     public int updateData(int id,String name);
}
