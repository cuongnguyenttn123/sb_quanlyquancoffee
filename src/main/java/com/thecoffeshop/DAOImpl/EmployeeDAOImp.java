package com.thecoffeshop.DAOImpl;

import com.thecoffeshop.entity.Employee;

import java.util.Collection;
import java.util.List;


public interface EmployeeDAOImp extends CommonDAOImp{

	public List<Employee> findAll();

	public List<Employee> findAllLimit(int start);

	public List<Employee> findLimit(int start);
	
	public Boolean addEmployee(Employee employee);

	public String logIn(String username, String password);
	
	public Employee getInfoById(String employeeid);
	
	public Boolean checkExistUseName(String usename);
	
	public Boolean deleteEmployee(String employeeid);

	public Boolean editEmployee(Employee employee);

}
