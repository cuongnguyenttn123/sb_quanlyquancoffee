package com.thecoffeshop.controller.admin;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thecoffeshop.service.EmployeeService;
import com.thecoffeshop.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {
	@Autowired
	MyUserDetailsService myUserDetailsService;

	@RequestMapping("/login1")
	public String login1(@RequestParam(required = false) String message, final Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
		return "admin/login";
	}
	@RequestMapping("/login2")
	public String login2(@RequestParam(required = false) String message, final Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
		return "/shipper/shipper";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "redirect:/admin/index";
	}

	@RequestMapping("/shipper")
	public String shipper() {
		return "redirect:/shipper/bill";
	}
	@RequestMapping("/logout")
	public String logout(final Model model) {
		model.addAttribute("message", "Logged out!");
		return "home";
	}
	@RequestMapping("/403")
	public String accessDenied403() {
		return "403";
	}

}
