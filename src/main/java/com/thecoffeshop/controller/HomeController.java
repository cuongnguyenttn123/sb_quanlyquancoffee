package com.thecoffeshop.controller;

import com.thecoffeshop.entity.Bill;
import com.thecoffeshop.entity.Billdetail;
import com.thecoffeshop.entity.Customer;
import com.thecoffeshop.entity.Employee;
import com.thecoffeshop.service.BillService;
import com.thecoffeshop.service.CustomerService;
import com.thecoffeshop.service.EmployeeService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/home/")
public class HomeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    BillService billService;

    @Autowired
    CustomerService customerService;

    @GetMapping("test")
    public String getHome(){
        List<Employee> employee = employeeService.findAll();
        return "home";
    }
}
