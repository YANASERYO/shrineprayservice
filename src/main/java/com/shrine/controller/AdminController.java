package com.shrine.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shrine.model.LoginUser;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminMenu(HttpSession session) {
    	
    		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
    		
    		if(loginUser == null) {
    			return "redirect:/login";
    		}
    		
//    		staffはadminに入れない
        if (!loginUser.isAdmin()) {
        		return "redirect:/staff";
        }

        return "admin/menu";
    }
}