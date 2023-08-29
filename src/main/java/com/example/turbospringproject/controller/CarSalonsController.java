package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.CarSalonsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/carSalons")
public class CarSalonsController {
    private final CarSalonsService carSalonsService;

    public CarSalonsController(CarSalonsService carSalonsService) {
        this.carSalonsService = carSalonsService;
    }
}
