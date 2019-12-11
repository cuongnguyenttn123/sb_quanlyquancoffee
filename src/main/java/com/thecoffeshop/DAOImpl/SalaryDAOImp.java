package com.thecoffeshop.DAOImpl;

import com.thecoffeshop.entity.Salary;

public interface SalaryDAOImp extends CommonDAOImp{

	public Boolean addSalary(Salary salary);

	public Salary getInfoById(int dinnertableid);

	public int getSalaryByEmployeeid(int employeeid);
	
	public Boolean deleteSalary(Salary Salary);

	public Boolean editSalary(Salary Salary);
	
}
