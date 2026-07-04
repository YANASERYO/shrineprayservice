package com.shrine.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shrine.entity.StaffNoticeEntity;
import com.shrine.service.ReservationService;
import com.shrine.service.StaffNoticeService;

@Controller
public class StaffController {
	
	private final StaffNoticeService staffNoticeService;
	private final ReservationService reservationService;

	public StaffController(StaffNoticeService staffNoticeService, ReservationService reservationService) {	
		this.reservationService = reservationService;
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
        
        model.addAttribute("todayUnprayedCount", reservationService.countTodayUnprayed());
        model.addAttribute("todayPrayedCount", reservationService.countTodayPrayed());
        
        
        return "staff/menu";
    }
}