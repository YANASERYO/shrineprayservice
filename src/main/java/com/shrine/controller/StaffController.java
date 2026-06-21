package com.shrine.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {

    @GetMapping("/staff")
    public String staffMenu(HttpSession session) {

        if (session.getAttribute("loginUser") == null) {
            return "redirect:/login";
        }

        return "staff/menu";
    }
}