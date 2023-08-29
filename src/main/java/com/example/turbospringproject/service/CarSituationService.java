package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repositroies.CarSituationRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarSituationService {
    private final CarSituationRep carSituationRep;

    public CarSituationService(CarSituationRep carSituationRep) {
        this.carSituationRep = carSituationRep;
    }
}
