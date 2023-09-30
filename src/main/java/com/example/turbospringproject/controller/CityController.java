package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.CityDto;
import com.example.turbospringproject.model.CityFilterDto;
import com.example.turbospringproject.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping()
    public List<CityDto> getAllCity() {
        return cityService.getAllCity();
    }

    @GetMapping("{cityId}")
    public CityDto getCity(@PathVariable Integer cityId) {
        return cityService.getCity(cityId);
    }

    @PostMapping
    public void saveCity(@RequestBody CityDto cityDto) {
        cityService.saveCity(cityDto);
    }

    @PutMapping
    public void updateCity(@RequestBody CityDto cityDto, @PathVariable Integer cityId) {
        cityService.editCity(cityDto, cityId);
    }

    @DeleteMapping
    public void deleteCity(@PathVariable Integer cityId) {
        cityService.deleteCity(cityId);
    }

    @GetMapping("/filter")
    public CityDto getCities(CityFilterDto cityFilterDto) {
        return cityService.getCities(cityFilterDto);
    }
}
