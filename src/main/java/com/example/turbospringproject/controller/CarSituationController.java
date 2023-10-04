package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.CarSituationDto;
import com.example.turbospringproject.service.CarSituationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carSituations")
public class CarSituationController {
    private final CarSituationService carSituationService;

    public CarSituationController(CarSituationService carSituationService) {
        this.carSituationService = carSituationService;
    }

    @GetMapping
    public List<CarSituationDto> getAllCarSituation() {
        return carSituationService.getAllCarSituation();

    }
}
