package com.nit.services;

import com.nit.beans.Employee;

public interface IEmployeeOperation 
{
    public void fetchData();
    public int addData(Employee emp);
    public int deleteData(int id);
    public int updateData(int id,String name);
}
