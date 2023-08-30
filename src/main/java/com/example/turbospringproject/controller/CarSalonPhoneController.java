package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.CarSalonsPhonesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/carSalonsPhones")
public class CarSalonPhoneController {
    private final CarSalonsPhonesService carSalonsPhonesService;

    public CarSalonPhoneController(CarSalonsPhonesService carSalonsPhonesService) {
        this.carSalonsPhonesService = carSalonsPhonesService;
    }
}
