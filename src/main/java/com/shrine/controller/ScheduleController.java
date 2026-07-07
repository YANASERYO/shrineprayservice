package com.shrine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.shrine.mapper.ScheduleMapper;
import com.shrine.service.ScheduleService;



@Controller
public class ScheduleController {
	
	private final ScheduleService scheduleService;
	private final ScheduleMapper scheduleMapper;
	
	public ScheduleController(ScheduleService scheduleService, ScheduleMapper scheduleMapper) {
		this.scheduleService = scheduleService;
		this.scheduleMapper = scheduleMapper;
	}
	
	@GetMapping("/staff/schedule/list")
	public String showForm(Model model) {
		model.addAttribute("scheduleForm", new ScheduleForm());
		return "staff/schedule/form";
	}
	
	@PostMapping("/staff/schedule")
	public String listSchedules(
			@RequestParam(defaultValue = "today")String filter,
			Model model,HttpSession session) {
		
			if (session.getAttribute("loginUser") == null) {
		    return "redirect:/login";
			}
			
			model.addAttribute("schedules", scheduleService.findSchedules(filter));
			model.addAttribute("filter", filter);
			return "staff/schedule/list";
	}
	
	@PostMapping("/staff/schedule/join")
	
}


