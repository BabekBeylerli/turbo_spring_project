package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.CitiesRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CitiesService {
    private final CitiesRep citiesRep;

    public CitiesService(CitiesRep citiesRep) {
        this.citiesRep = citiesRep;
    }
}
