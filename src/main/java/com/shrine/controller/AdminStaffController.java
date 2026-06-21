package com.shrine.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shrine.entity.StaffAccountEntity;
import com.shrine.form.StaffAccountForm;
import com.shrine.repository.StaffAccountRepository;

@Controller
@RequestMapping("/admin/staff")
public class AdminStaffController {

    private final StaffAccountRepository staffAccountRepository;

    public AdminStaffController(StaffAccountRepository staffAccountRepository) {
        this.staffAccountRepository = staffAccountRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("staffList", staffAccountRepository.findAll());
        return "admin/staff/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("staffAccountForm", new StaffAccountForm());
        return "admin/staff/form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute StaffAccountForm staffAccountForm) {

        StaffAccountEntity staff = new StaffAccountEntity();

        staff.setUsername(staffAccountForm.getUsername());
        staff.setPassword(staffAccountForm.getPassword());
        staff.setStaffName(staffAccountForm.getStaffName());
        staff.setRole("STAFF");
        staff.setEnabled(true);
        staff.setCreatedAt(LocalDateTime.now());

        staffAccountRepository.save(staff);

        return "redirect:/admin/staff";
    }
}