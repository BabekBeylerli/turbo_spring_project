package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.CarSalonPhoneEntity;
import com.example.turbospringproject.dao.repository.CarSalonPhoneRepository;
import com.example.turbospringproject.mapper.CarSalonMapper;
import com.example.turbospringproject.mapper.CarSalonPhoneMapper;
import com.example.turbospringproject.model.CarSalonDto;
import com.example.turbospringproject.model.CarSalonPhoneDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarSalonPhoneService {
    private final CarSalonPhoneRepository carSalonPhoneRepository;

    public CarSalonPhoneService(CarSalonPhoneRepository carSalonPhoneRepository) {
        this.carSalonPhoneRepository = carSalonPhoneRepository;
    }

    public List<CarSalonPhoneDto> getAllCarSalonPhone() {
        log.info("ActionLog.getAllCarSalonPhone.start");
        List<CarSalonPhoneDto> carSalonPhoneDtos =
                CarSalonPhoneMapper.mapper.mapEntityToDtos(carSalonPhoneRepository.findAll());
        log.info("ActionLog.getAllCarSalonPhone.end");
        return carSalonPhoneDtos;
    }

    public CarSalonPhoneDto getCarSalonPhone(Integer carSalonPhoneId) {
        log.info("ActionLog.getCarSalonPhone.start");
        CarSalonPhoneEntity carSalonPhoneEntity =
                carSalonPhoneRepository.findById(carSalonPhoneId).orElseThrow(() ->
                        new RuntimeException("NotFound")
                );
        log.info("ActionLog.getCarSalonPhone.end");
        return CarSalonPhoneMapper.mapper.mapEntityToDto(carSalonPhoneEntity);
    }

    public void saveCarSalonPhone(CarSalonPhoneDto carSalonPhoneDto) {
        log.info("ActionLog.saveCarSalonPhone.start");
        carSalonPhoneRepository.save(CarSalonPhoneMapper.mapper.mapDtoToEntity(carSalonPhoneDto));
        log.info("ActionLog.saveCarSalonPhone.end");
    }

    public void editCarSalonPhone(CarSalonPhoneDto carSalonPhoneDto, Integer carSalonPhoneId) {
        log.info("ActionLog.editCarSalonPhone.start");
        carSalonPhoneRepository.save(CarSalonPhoneMapper.mapper.mapDtoToEntity(carSalonPhoneDto, carSalonPhoneId));
        log.info("ActionLog.editCarSalonPhone.end");
    }

    public void deleteCarSalonPhone(Integer carSalonPhoneId) {
        log.info("ActionLog.deleteCarSalonPhone.start");
        carSalonPhoneRepository.deleteById(carSalonPhoneId);
        log.info("ActionLog.deleteCarSalonPhone.end");
    }

}
