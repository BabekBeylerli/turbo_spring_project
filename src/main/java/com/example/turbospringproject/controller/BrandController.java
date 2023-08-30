package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.BrandsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/brands")
public class BrandController {
    private final BrandsService brandsService;

    public BrandController(BrandsService brandsService) {
        this.brandsService = brandsService;
    }
}
