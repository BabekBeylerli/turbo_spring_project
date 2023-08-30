package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.CarSalonPhoneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/carSalonsPhones")
public class CarSalonPhoneController {
    private final CarSalonPhoneService carSalonsPhonesService;

    public CarSalonPhoneController(CarSalonPhoneService carSalonsPhonesService) {
        this.carSalonsPhonesService = carSalonsPhonesService;
    }
}
