package com.api.helpdesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.helpdesk.models.User;

@Controller
public class AuthLoginController {
	
	@GetMapping("/login")
	public String login(Model model) {
		return "auth/login";
	};
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "auth/registration";
	};

}
