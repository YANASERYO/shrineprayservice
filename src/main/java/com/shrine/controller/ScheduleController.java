package com.shrine.controller;

import org.springframework.stereotype.Controller;

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
	
	

}
