package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.CityDto;
import com.example.turbospringproject.service.CityService;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/admin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void saveCity(@RequestBody CityDto cityDto) {
        cityService.saveCity(cityDto);
    }

    @PutMapping("/admin/{cityId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateCity(@RequestBody CityDto cityDto, @PathVariable Integer cityId) {
        cityService.editCity(cityDto, cityId);
    }

    @DeleteMapping("/admin/{cityId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteCity(@PathVariable Integer cityId) {
        cityService.deleteCity(cityId);
    }

}
