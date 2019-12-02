package com.thecoffeshop.common.converter;

import com.thecoffeshop.entity.Employee;

import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Converter
public class EmployeeConverter {
    public List<Employee> converterIsDelete(List<Employee> employees){
        List<Employee> employees1 = new ArrayList<>();
        for (Employee x: employees) {
            if (x.getIsdelete()!=true){
                Employee employee = new Employee();
                employee.setEmployeeid(x.getEmployeeid());
                employee.setName(x.getName());
                employee.setSex(x.getSex());
                employee.setAddress(x.getAddress());
                employee.setUsename(x.getUsename());
                employee.setPassword(x.getPassword());
                employee.setIsdelete(x.getIsdelete());
                employee.setUpdateat(x.getUpdateat());
                employees1.add(employee);
            }
        }
        return employees1;
    }
}
