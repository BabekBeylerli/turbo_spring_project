package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.CarSituationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/carSituation")
public class CarSituationController {
    private final CarSituationService carSituationService;

    public CarSituationController(CarSituationService carSituationService) {
        this.carSituationService = carSituationService;
    }
}
