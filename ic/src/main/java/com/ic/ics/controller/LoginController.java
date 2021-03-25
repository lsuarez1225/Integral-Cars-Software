package com.ic.ics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ic.ics.form.LoginForm;

@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public String getLoginForm() {
		return "user-form/login";
	}
	
	@PostMapping(value = "/login")
	public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {
		//String username = loginForm.getUsername();
		//String password = loginForm.getPassword();
		
		//model.addAttribute("invalidCredentials", true);
		return "user-form/login";
	}
}
