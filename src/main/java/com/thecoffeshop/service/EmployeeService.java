package com.thecoffeshop.service;

import com.thecoffeshop.DAO.EmployeeDAO;
import com.thecoffeshop.DAOImpl.EmployeeDAOImp;
import com.thecoffeshop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeService implements EmployeeDAOImp {
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public List<Employee> findAllLimit(int start) {
        return employeeDAO.findAllLimit(start);
    }

    @Override
    public List<Employee> findLimit(int startPosition) {
        return employeeDAO.findAllLimit(startPosition);
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    public String logIn(String username, String password) {
        return employeeDAO.logIn(username, password);
    }

    @Override
    public Employee getInfoById(String employeeid) {
        return employeeDAO.getInfoById(employeeid);
    }

    @Override
    public Boolean checkExistUseName(String usename) {
        return employeeDAO.checkExistUseName(usename);
    }

    @Override
    public Boolean deleteEmployee(String employeeid) {
        return employeeDAO.deleteEmployee(employeeid);
    }

    @Override
    public Boolean editEmployee(Employee employee) {
        return employeeDAO.editEmployee(employee);
    }
}
