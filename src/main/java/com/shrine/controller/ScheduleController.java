package com.shrine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	    schedule.setStaffName(loginUser.getStaffName());
	    
	    
		scheduleService.create(schedule);
	    return "redirect:/staff/schedule";
	}
	
	@PostMapping("/staff/schedule/{id}/delete")
	public String delete(@PathVariable Long id) {
	    scheduleService.delete(id);
	    return "redirect:/staff/schedule";
	}
	
	@GetMapping("/staff/schedule/events")
    @ResponseBody
    public List<Map<String, Object>> calendarEvents() {
        return scheduleService.findAllNotDeleted().stream()
                .filter(schedule -> schedule.getDate() != null)
                .filter(schedule -> schedule.getStartTime() != null)
                .map(schedule -> {
                    Map<String, Object> event = new HashMap<>();

                    String title = schedule.getName();

                    if (schedule.getGenre() != null && !schedule.getGenre().isBlank()) {
                        title = "【" + schedule.getGenre() + "】" + schedule.getName();
                    }

                    event.put("title", title);
                    event.put("start", schedule.getDate() + "T" + schedule.getStartTime());

                    if (schedule.getEndTime() != null) {
                        event.put("end", schedule.getDate() + "T" + schedule.getEndTime());
                    }

                    return event;
                })
                .toList();
    }
	
}


