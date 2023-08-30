package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.CarSalonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/carSalons")
public class CarSalonController {
    private final CarSalonService carSalonsService;

    public CarSalonController(CarSalonService carSalonsService) {
        this.carSalonsService = carSalonsService;
    }
}
