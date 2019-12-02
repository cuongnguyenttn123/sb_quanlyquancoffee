package com.thecoffeshop.controller.user;

import com.thecoffeshop.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserLogoutController {
    @GetMapping("/logout")
    public String getLogout(HttpSession httpSession){
        Customer customer = null;
        httpSession.setAttribute("customer", customer);
        httpSession.invalidate();
        //httpSession.removeAttribute("customer");
        return "redirect:/";
    }
}
