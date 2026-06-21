package com.shrine.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shrine.entity.PostalCodeMaster;
import com.shrine.service.PostalCodeService;

@RestController
public class PostalCodeController {

    private final PostalCodeService postalCodeService;

    public PostalCodeController(PostalCodeService postalCodeService) {
        this.postalCodeService = postalCodeService;
    }

    @GetMapping("/api/postal-code")
    public List<PostalCodeMaster> findByPostalCode(@RequestParam String postalCode) {
        return postalCodeService.findByPostalCode(postalCode);
    }
}