package com.thecoffeshop.service;

import com.thecoffeshop.DAO.SalaryDAO;
import com.thecoffeshop.DAOImpl.SalaryDAOImp;
import com.thecoffeshop.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class SalaryService implements SalaryDAOImp {

	@Autowired
	SalaryDAO salaryDAO;

	@Override
	public Boolean addSalary(Salary salary) {
		// TODO Auto-generated method stub
		return salaryDAO.addSalary(salary);
	}

	@Override
	public Salary getInfoById(int dinnertableid) {
		// TODO Auto-generated method stub
		return salaryDAO.getInfoById(dinnertableid);
	}

	@Override
	public Boolean deleteSalary(Salary Salary) {
		// TODO Auto-generated method stub
		return salaryDAO.deleteSalary(Salary);
	}

	@Override
	public Boolean editSalary(Salary salary) {
		// TODO Auto-generated method stub
		return salaryDAO.editSalary(salary);
	}

	@Override
	public int getSalaryByEmployeeid(int employeeid) {
		// TODO Auto-generated method stub
		return salaryDAO.getSalaryByEmployeeid(employeeid);
	}
	
}