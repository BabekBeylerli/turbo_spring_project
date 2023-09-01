package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.CarSalonEntity;
import com.example.turbospringproject.dao.repository.BrandRepository;
import com.example.turbospringproject.dao.repository.CarSalonRepository;
import com.example.turbospringproject.mapper.BrandMapper;
import com.example.turbospringproject.mapper.CarSalonMapper;
import com.example.turbospringproject.mapper.CarSalonPhoneMapper;
import com.example.turbospringproject.model.BrandDto;
import com.example.turbospringproject.model.CarSalonDto;
import com.example.turbospringproject.model.CarSalonPhoneDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarSalonService {
    private final CarSalonRepository carSalonsRepository;

    public CarSalonService(CarSalonRepository carSalonsRepository) {

        this.carSalonsRepository = carSalonsRepository;
    }

    public List<CarSalonDto> getAllCarSalon() {
        log.info("ActionLog.getAllCarSalon.start");
        List<CarSalonDto> carSalonDtos =
                CarSalonMapper.mapper.mapEntityToDtos(carSalonsRepository.findAll());
        log.info("ActionLog.getAllCarSalon.end");
        return carSalonDtos;
    }

    public CarSalonDto getCarSalon(Integer carSalonId) {
        log.info("ActionLog.getCarSalon.start");
        CarSalonEntity carSalonEntity =
                carSalonsRepository.findById(carSalonId).orElseThrow(() ->
                        new RuntimeException("NotFound")
                );
        log.info("ActionLog.getCarSalon.end");
        return CarSalonMapper.mapper.mapEntityToDto(carSalonEntity);
    }

    public void saveCarSalon(CarSalonDto carSalonDto) {
        log.info("ActionLog.saveCarSalon.start");
        carSalonsRepository.save(CarSalonMapper.mapper.mapDtoToEntity(carSalonDto));
        log.info("ActionLog.saveCarSalon.end");
    }

    public void editCarSalon(CarSalonDto carSalonDto, Integer carSalonId) {
        log.info("ActionLog.editCarSalon.start");
        carSalonsRepository.save(CarSalonMapper.mapper.mapDtoToEntity(carSalonDto, carSalonId));
        log.info("ActionLog.editCarSalon.end");
    }

    public void deleteCarSalon(Integer carSalonId) {
        log.info("ActionLog.deleteCarSalon.start");
        carSalonsRepository.deleteById(carSalonId);
        log.info("ActionLog.deleteCarSalon.end");
    }
}
