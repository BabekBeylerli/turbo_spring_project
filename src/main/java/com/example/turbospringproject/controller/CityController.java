package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cities")
public class CityController {
    private final CityService citiesService;

    public CityController(CityService citiesService) {
        this.citiesService = citiesService;
    }
}
