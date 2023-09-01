package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.CarSituationEntity;
import com.example.turbospringproject.dao.repository.CarSituationRepository;
import com.example.turbospringproject.mapper.CarSalonMapper;
import com.example.turbospringproject.mapper.CarSituationMapper;
import com.example.turbospringproject.model.CarSalonDto;
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

    public List<CarSituationDto> getAllCarSituation() {
        log.info("ActionLog.getAllCarSituation.start");
        List<CarSituationDto> carSituationDtos =
                CarSituationMapper.mapper.mapEntityToDtos(carSituationRepository.findAll());
        log.info("ActionLog.getAllCarSituation.end");
        return carSituationDtos;
    }
    public CarSituationDto getCarSituation(Integer carSituationId) {
     log.info("ActionLog.getCarSituation.start");
        CarSituationEntity carSituationEntity=
                carSituationRepository.findById(carSituationId).orElseThrow(() ->
                        new RuntimeException("Not Found")
                );
        log.info("ActionLog.getCarSituation.end");
        return CarSituationMapper.mapper.mapEntityToDto(carSituationEntity);
    }

    public void saveCarSituation(CarSituationDto carSituationDto) {
        log.info("ActionLog.saveCarSituation.start");
        carSituationRepository.save(CarSituationMapper.mapper.mapDtoToEntity(carSituationDto));
        log.info("ActionLog.saveCarSituation.end");
    }

    public void editCarSituation(CarSituationDto carSituationDto, Integer carSituationId) {
        log.info("ActionLog.editCarSituation.start");
        carSituationRepository.save(CarSituationMapper.mapper.mapDtoToEntity(carSituationDto, carSituationId));
        log.info("ActionLog.editCarSituation.end");
    }

    public void deleteCarSituation(Integer carSituationId) {
        log.info("ActionLog.deleteCarSituation.start");
        carSituationRepository.deleteById(carSituationId);
        log.info("ActionLog.deleteCarSituation.end");

    }
}
