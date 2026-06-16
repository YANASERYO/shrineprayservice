package com.shrine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReservationController {

//	@GetMapping("/test")
//	@ResponseBody
//	public String test() {
//		return "Controller OK";
//	}

    @GetMapping("/reservations/new")
    public String showForm() {
        return "reservation/form";
    }

    @PostMapping("/reservations")
    public String createReservation(
    		@RequestParam String name,
        @RequestParam String kana,
        @RequestParam String birthday,
        @RequestParam String phone,
        @RequestParam String address,
        @RequestParam String email,
        @RequestParam String preferredDate,
        @RequestParam String prayerType,
        @RequestParam(required = false) String note,
        Model model) {
        	
        	model.addAttribute("name", name);
        model.addAttribute("kana", kana);
        model.addAttribute("birthday", birthday);
        model.addAttribute("phone", phone);
        model.addAttribute("address", address);
        model.addAttribute("email", email);
        model.addAttribute("preferredDate", preferredDate);
        model.addAttribute("prayerType", prayerType);
        model.addAttribute("note", note);
        return "reservation/complete";
    }
}
