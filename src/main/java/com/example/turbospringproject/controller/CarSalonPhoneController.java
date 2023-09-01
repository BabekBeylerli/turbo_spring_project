package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.CarSalonDto;
import com.example.turbospringproject.model.CarSalonPhoneDto;
import com.example.turbospringproject.service.CarSalonPhoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carSalonPhones")
public class CarSalonPhoneController {
    private final CarSalonPhoneService carSalonPhoneService;

    public CarSalonPhoneController(CarSalonPhoneService carSalonPhoneService) {
        this.carSalonPhoneService = carSalonPhoneService;
    }
    @GetMapping
    public List<CarSalonPhoneDto> getAllCarSalonPhone(){
        return carSalonPhoneService.getAllCarSalonPhone();
    }
    @GetMapping("{carSalonPhoneId}")
    public CarSalonPhoneDto getCarSalonPhone(@PathVariable Integer carSalonPhoneId){
        return carSalonPhoneService.getCarSalonPhone(carSalonPhoneId);
    }
    @PostMapping
    public void saveCarSalonPhone(@RequestBody CarSalonPhoneDto carSalonPhoneDto){
        carSalonPhoneService.saveCarSalonPhone(carSalonPhoneDto);
    }
    @PutMapping
    public void updateCarSalon(@RequestBody CarSalonPhoneDto carSalonPhoneDto,@PathVariable Integer carSalonPhoneId){
        carSalonPhoneService.editCarSalonPhone(carSalonPhoneDto,carSalonPhoneId);
    }
    @DeleteMapping
    public void deleteCarSalon(@PathVariable Integer carSalonPhoneId){
        carSalonPhoneService.deleteCarSalonPhone(carSalonPhoneId);
    }
}
