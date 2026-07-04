package com.shrine.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shrine.entity.StaffNoticeEntity;
import com.shrine.service.StaffNoticeService;

@Controller
public class StaffController {
	
	private final StaffNoticeService staffNoticeService;

	public StaffController(StaffNoticeService staffNoticeService) {
		this.staffNoticeService = staffNoticeService;
	}
	
    @GetMapping("/staff")
    public String staffMenu(HttpSession session,Model model) {

        if (session.getAttribute("loginUser") == null) {
            return "redirect:/login";
        }
        
        List<StaffNoticeEntity> notices = staffNoticeService.findAllNotices();
        
        model.addAttribute("notices", notices);
        model.addAttribute("notice", new StaffNoticeEntity());

        return "staff/menu";
    }
}