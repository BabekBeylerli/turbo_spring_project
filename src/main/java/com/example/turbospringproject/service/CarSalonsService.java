package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.CarSalonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarSalonsService {
    private final CarSalonRepository carSalonsRep;

    public CarSalonsService(CarSalonRepository carSalonsRep) {
        this.carSalonsRep = carSalonsRep;
    }
}
