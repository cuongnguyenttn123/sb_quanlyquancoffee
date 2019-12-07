package com.thecoffeshop.service;

import com.thecoffeshop.entity.Employee;
import com.thecoffeshop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    EmployeeRepository employeeRepository;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsename(s);
        if (employee == null){
            return null;
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new User(employee.getUsename(), employee.getPassword(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, employee.getAuthorities());
    }
}
