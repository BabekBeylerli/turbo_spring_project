package com.example.turbospringproject.controller;

import com.example.turbospringproject.dao.entity.enums.ECarSalon;
import com.example.turbospringproject.model.BrandDto;
import com.example.turbospringproject.model.CarSalonDto;
import com.example.turbospringproject.model.CarSalonLiteDto;
import com.example.turbospringproject.service.CarSalonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carSalons")
public class CarSalonController {
    private final CarSalonService carSalonService;

    public CarSalonController(CarSalonService carSalonService) {
        this.carSalonService = carSalonService;
    }
    @GetMapping("/bySalonType/{salonType}")
    public List<CarSalonLiteDto> getAllCarSalon(@PathVariable ECarSalon salonType){
        return carSalonService.getAllCarSalon(salonType);
    }
    @GetMapping("/byId/{carSalonId}")
    public CarSalonDto getCarSalon(@PathVariable Integer carSalonId){
        return carSalonService.getCarSalon(carSalonId);
    }
    @PostMapping
    public void saveCarSalon(@RequestBody CarSalonDto carSalonDto){
        carSalonService.saveCarSalon(carSalonDto);
    }
    @PutMapping
    public void updateCarSalon(@RequestBody CarSalonDto carSalonDto,@PathVariable Integer carSalonId){
        carSalonService.editCarSalon(carSalonDto,carSalonId);
    }
    @DeleteMapping
    public void deleteCarSalon(@PathVariable Integer carSalonId){
        carSalonService.deleteCarSalon(carSalonId);
    }
}
