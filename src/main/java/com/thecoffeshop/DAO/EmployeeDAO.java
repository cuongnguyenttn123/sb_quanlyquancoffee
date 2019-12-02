package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.EmployeeDAOImp;
import com.thecoffeshop.entity.Employee;
import com.thecoffeshop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeDAO implements EmployeeDAOImp {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByIsdelete(this.IS_NOT_DELETE);
    }

    @Override
    public List<Employee> findAllLimit(int start) {
        return employeeRepository.findAllLimit(this.IS_NOT_DELETE,start*this.MAX_RESULTS,this.MAX_RESULTS);
    }

    @Override
    public List<Employee> findLimit(int startPosition) {
        List<Employee> employees;
        try {
            int size = employeeRepository.findAll().size();
            int fromIndex = startPosition*this.MAX_RESULTS;
            int toIndex = startPosition*this.MAX_RESULTS+this.MAX_RESULTS;
            if (size>toIndex){
                employees = employeeRepository.findAll().subList(fromIndex, toIndex);
            }else {
                employees = employeeRepository.findAll().subList(fromIndex, size);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            employees = null;
        }
        return employees;
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        Boolean aBoolean;
        try {
            employeeRepository.save(employee);
            aBoolean = true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    public String logIn(String username, String password) {
        String employeeId = "";
        Employee employee;
        try{
            employee = employeeRepository.logIn(username, password);
            employeeId = employee.getEmployeeid();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return employeeId;
    }

    @Override
    public Employee getInfoById(String employeeid) {
        return employeeRepository.findById(employeeid).get();
    }

    @Override
    public Boolean checkExistUseName(String usename) {
        Boolean aBoolean;
        Employee employee;
        try {
            employee = employeeRepository.findByUsename(usename);
            if (employee != null){
                aBoolean = true;
            } else {
                aBoolean = false;
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            aBoolean = false;
        }
        return aBoolean;
    }

    @Override
    @Transactional
    public Boolean deleteEmployee(String employeeid) {
        Boolean aBoolean = false;
        try {
            employeeRepository.deleteById(employeeid);
            aBoolean = true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return aBoolean;
    }

    @Override
    @Transactional
    public Boolean editEmployee(Employee employee) {
        Boolean aBoolean = false;
        try {
            employeeRepository.save(employee);
            aBoolean = true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            aBoolean = false;
        }
        return aBoolean;
    }
}
