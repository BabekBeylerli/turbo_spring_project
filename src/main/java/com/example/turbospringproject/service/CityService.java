package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.CitiesRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CityService {
    private final CitiesRep citiesRep;

    public CityService(CitiesRep citiesRep) {
        this.citiesRep = citiesRep;
    }
}