package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.CarSalonPhoneDto;
import com.example.turbospringproject.model.CarSituationDto;
import com.example.turbospringproject.model.CarSituationFilterDto;
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

    @GetMapping("filter")
    public List<CarSituationDto> getFilteredCarSituations(CarSituationFilterDto carSituationFilterDto) {
        return carSituationService.getFilteredCarSituations(carSituationFilterDto);
    }

    @GetMapping("{carSituationId}")
    public CarSituationDto getCarSituation(@PathVariable Integer carSituationId) {
        return carSituationService.getCarSituation(carSituationId);
    }

    @PostMapping
    public void saveCarSituation(@RequestBody CarSituationDto carSituationDto) {
        carSituationService.saveCarSituation(carSituationDto);
    }

    @PutMapping
    public void updateCarSituation(@RequestBody CarSituationDto carSituationDto, @PathVariable Integer carSituationId) {
        carSituationService.editCarSituation(carSituationDto, carSituationId);
    }

    @DeleteMapping
    public void deleteCarSituation(@PathVariable Integer carSituationId) {
        carSituationService.deleteCarSituation(carSituationId);
    }
}
