package com.shrine.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shrine.entity.ScheduleEntity;
import com.shrine.model.LoginUser;
import com.shrine.service.ScheduleService;


@Controller
public class ScheduleController {
	
	private final ScheduleService scheduleService;
	
	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	

	@GetMapping("/staff/schedule")
	public String listSchedules(Model model) {
			model.addAttribute("schedules", scheduleService.findAllNotDeleted());
			model.addAttribute("schedule", new ScheduleEntity());
			return "staff/schedule/scheduleMenu";
	}

	@PostMapping("/staff/schedule/create")
	public String create(@ModelAttribute ScheduleEntity schedule, HttpSession session) {
	    
		LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

	    if (loginUser == null) {
	        return "redirect:/login";
	    }

	    schedule.setStaffAccount(loginUser.getUserId());
		scheduleService.create(schedule);
	    return "redirect:/staff/scheduleMenu";
	}
	
	@PostMapping("/staff/schedule/{id}/delete")
	public String delete(@PathVariable Long id) {
	    scheduleService.delete(id);
	    return "redirect:/staff/schedule";
	}
}


