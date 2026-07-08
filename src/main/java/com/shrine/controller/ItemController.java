package com.shrine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shrine.service.ItemService;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/staff/productItemManagement")
    public String list(Model model) {
        model.addAttribute("items", itemService.findAllItems());
        return "staff/item/list";
    }
}