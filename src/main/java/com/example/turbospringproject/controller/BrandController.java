package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/brands")
public class BrandController {
    private final BrandService brandsService;

    public BrandController(BrandService brandsService) {
        this.brandsService = brandsService;
    }
}
