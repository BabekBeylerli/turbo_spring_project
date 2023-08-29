package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repositroies.CarSalonsPhonesRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarSalonsPhonesService {
    private final CarSalonsPhonesRep carSalonsPhonesRep;

    public CarSalonsPhonesService(CarSalonsPhonesRep carSalonsPhonesRep) {
        this.carSalonsPhonesRep = carSalonsPhonesRep;
    }
}
