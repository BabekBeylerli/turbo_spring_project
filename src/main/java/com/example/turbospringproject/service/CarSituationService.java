package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.CarSituationRepository;
import com.example.turbospringproject.mapper.CarSalonMapper;
import com.example.turbospringproject.mapper.CarSituationMapper;
import com.example.turbospringproject.model.CarSituationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarSituationService {
    private final CarSituationRepository carSituationRepository;

    public CarSituationService(CarSituationRepository carSituationRepository) {

        this.carSituationRepository = carSituationRepository;
    }

    public List<CarSituationDto> getAllCarSituations() {
        return CarSituationMapper.mapper.mapEntityToDtos(carSituationRepository.findAll());
    }

    public CarSituationDto getCarSituation(Integer carSituationId) {
        return CarSituationMapper.mapper.mapEntityToDto(carSituationRepository.findById(carSituationId).orElseThrow(() ->
                new RuntimeException("Not Found")
        ));
    }

    public void saveCarSituation(CarSituationDto carSituationDto) {
        carSituationRepository.save(CarSituationMapper.mapper.mapDtoToEntity(carSituationDto));
    }

    public void editCarSituation(CarSituationDto carSituationDto, Integer carSituationId) {
        carSituationRepository.save(CarSituationMapper.mapper.mapDtoToEntity(carSituationDto, carSituationId));
    }

    public void deleteCarSituation(Integer carSituationId) {
        carSituationRepository.deleteById(carSituationId);

    }
}
