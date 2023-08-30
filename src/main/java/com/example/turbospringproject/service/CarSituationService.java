package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.CarSituationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarSituationService {
    private final CarSituationRepository carSituationRep;

    public CarSituationService(CarSituationRepository carSituationRep) {
        this.carSituationRep = carSituationRep;
    }
}
