package com.thecoffeshop.controller;

import com.thecoffeshop.entity.Bill;
import com.thecoffeshop.entity.Employee;
import com.thecoffeshop.service.BillService;
import com.thecoffeshop.service.EmployeeService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    BillService billService;

    @GetMapping("")
    public String getHome(){

        return "home";
    }
}
