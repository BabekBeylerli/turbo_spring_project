package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.CitiesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cities")
public class CityController {
    private final CitiesService citiesService;

    public CityController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }
}
