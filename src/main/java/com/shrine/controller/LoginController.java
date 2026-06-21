package com.shrine.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shrine.model.LoginUser;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(
	        @RequestParam String userId,
	        @RequestParam String password,
	        HttpSession session,
	        Model model) {

	    if ("admin".equals(userId) && "admin1234".equals(password)) {
	        LoginUser loginUser = new LoginUser(userId, "ADMIN");
	        session.setAttribute("loginUser", loginUser);
	        return "redirect:/admin";
	    }

	    if ("staff".equals(userId) && "staff1234".equals(password)) {
	        LoginUser loginUser = new LoginUser(userId, "STAFF");
	        session.setAttribute("loginUser", loginUser);
	        return "redirect:/staff";
	    }

	    model.addAttribute("errorMsg", "IDまたはパスワードが違います");
	    return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/";
	}

}
