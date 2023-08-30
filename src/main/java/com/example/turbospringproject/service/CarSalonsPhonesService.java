package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.CarSalonPhoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarSalonsPhonesService {
    private final CarSalonPhoneRepository carSalonsPhonesRep;

    public CarSalonsPhonesService(CarSalonPhoneRepository carSalonsPhonesRep) {
        this.carSalonsPhonesRep = carSalonsPhonesRep;
    }
}
