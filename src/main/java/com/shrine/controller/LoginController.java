package com.shrine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
	
//    Spring Securityを使用
//	@GetMapping("/login")
//	public String showLoginForm() {
//		return "login";
//	}
//	
//	@PostMapping("/login")
//	public String login(
//	        @RequestParam String userId,
//	        @RequestParam String password,
//	        HttpSession session,
//	        Model model) {
//
//	    if ("admin".equals(userId) && "admin1234".equals(password)) {
//	        LoginUser loginUser = new LoginUser(userId, "ADMIN");
//	        session.setAttribute("loginUser", loginUser);
//	        return "redirect:/admin";
//	    }
//
//	    Optional<StaffAccountEntity> staffOpt = staffAccountRepository.findByUsername(userId);
//
//        if (staffOpt.isPresent()) {
//            StaffAccountEntity staff = staffOpt.get();
//
//            if (staff.getPassword().equals(password) && staff.getEnabled()) {
//                LoginUser loginUser = new LoginUser(staff.getUsername(), "STAFF");
//                session.setAttribute("loginUser", loginUser);
//                return "redirect:/staff";
//            }
//        }
//
//	    model.addAttribute("errorMsg", "IDまたはパスワードが違います");
//	    return "login";
//	}
	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//	    session.invalidate();
//	    return "redirect:/";
//	}