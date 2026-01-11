package com.requirement;

import java.util.ArrayList;
import com.bean.EmployeeBean;

public interface EmployeeService 
{
	public int insert(EmployeeBean eb);
	public ArrayList<EmployeeBean> select();
	public int update(EmployeeBean eb);
	public int delete(EmployeeBean eb);
}
