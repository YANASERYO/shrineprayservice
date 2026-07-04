package com.shrine.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.shrine.entity.StaffAccountEntity;
import com.shrine.entity.StaffNoticeEntity;
import com.shrine.model.LoginUser;
import com.shrine.repository.StaffAccountRepository;
import com.shrine.service.StaffNoticeService;


@Controller
public class StaffNoticeController {
    
    private final StaffNoticeService staffNoticeService;
    private final StaffAccountRepository staffAccountRepository;
    
    public StaffNoticeController(
            StaffNoticeService staffNoticeService,
            StaffAccountRepository staffAccountRepository) {
        this.staffNoticeService = staffNoticeService;
        this.staffAccountRepository = staffAccountRepository;
    }
    
    
    @PostMapping("/staff/notices/create")
    public String create(StaffNoticeEntity notice, HttpSession session) {
        
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        
        if (loginUser == null) {
            return "redirect:login";
        }
        
        StaffAccountEntity staffAccount = staffAccountRepository
        		.findById(Long.valueOf(loginUser.getUserId()))
        		.orElseThrow();
        
        notice.setStaffAccount(staffAccount);
        
        staffNoticeService.createNotice(notice);
        
        return "redirect:/staff";
    }
}
