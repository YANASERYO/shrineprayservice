package com.shrine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shrine.entity.SupporterEntity;
import com.shrine.service.SupporterService;

@Controller
public class SupporterManagementController {

    private final SupporterService supporterService;

    public SupporterManagementController(SupporterService supporterService) {
        this.supporterService = supporterService;
    }

    @GetMapping("/staff/supporterManagement")
    public String list(
            @RequestParam(required = false) String supporterType,
            Model model) {

        if (supporterType == null || supporterType.isBlank()) {
            model.addAttribute(
                    "supporters",
                    supporterService.findAllActiveSupporters()
            );
        } else {
            model.addAttribute(
                    "supporters",
                    supporterService.findBySupporterType(supporterType)
            );
        }

        model.addAttribute("supporter", new SupporterEntity());
        model.addAttribute("supporterType", supporterType);

        return "staff/supporter/list";
    }

    @PostMapping("/staff/supporterManagement/create")
    public String create(@ModelAttribute SupporterEntity supporter) {
        supporterService.create(supporter);
        return "redirect:/staff/supporterManagement";
    }

    @GetMapping("/staff/supporterManagement/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        SupporterEntity supporter = supporterService.findById(id);

        if (supporter == null) {
            return "error/404";
        }

        model.addAttribute("supporter", supporter);

        return "staff/supporter/edit";
    }

    @PostMapping("/staff/supporterManagement/{id}/update")
    public String update(
            @PathVariable Long id,
            @ModelAttribute SupporterEntity supporter) {

        supporterService.update(id, supporter);

        return "redirect:/staff/supporterManagement";
    }

    @PostMapping("/staff/supporterManagement/{id}/delete")
    public String delete(@PathVariable Long id) {
        supporterService.deactivate(id);
        return "redirect:/staff/supporterManagement";
    }
}