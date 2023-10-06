package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.CarSalonEntity;
import com.example.turbospringproject.dao.entity.enums.ECarSalon;
import com.example.turbospringproject.dao.repository.BrandRepository;
import com.example.turbospringproject.dao.repository.CarSalonRepository;
import com.example.turbospringproject.mapper.BrandMapper;
import com.example.turbospringproject.mapper.CarSalonMapper;
import com.example.turbospringproject.mapper.CarSalonPhoneMapper;
import com.example.turbospringproject.model.BrandDto;
import com.example.turbospringproject.model.CarSalonDto;
import com.example.turbospringproject.model.CarSalonLiteDto;
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

    public List<CarSalonLiteDto> getAllCarSalon(ECarSalon type) {
        log.info("ActionLog.getAllCarSalon.start");
        List<CarSalonLiteDto> carSalonLiteDtos =
                CarSalonMapper.mapper.mapEntityToDtos2(carSalonsRepository.findAllByType(type));
        log.info("ActionLog.getAllCarSalon.end");
        return carSalonLiteDtos;
    }

    public CarSalonDto getCarSalon(Integer carSalonId) {
        log.info("ActionLog.getCarSalon.start");
        CarSalonEntity carSalonEntity = carSalonsRepository.findById(carSalonId).orElseThrow(() ->
                new RuntimeException("NotFound")
        );
        log.info("ActionLog.getCarSalon.end");
        int currentViewNumber = carSalonEntity.getViewNumber();
        carSalonEntity.setViewNumber(currentViewNumber + 1);
        carSalonsRepository.save(carSalonEntity);
        return CarSalonMapper.mapper.mapEntityToDto(carSalonEntity);
    }

    public void saveCarSalon(CarSalonLiteDto carSalonLiteDto) {
        log.info("ActionLog.saveCarSalon.start");
        carSalonsRepository.save(CarSalonMapper.mapper.mapLiteDtoToEntity(carSalonLiteDto));
        log.info("ActionLog.saveCarSalon.end");
    }

    public void editCarSalon(CarSalonDto carSalonDto, Integer carSalonId) {
        log.info("ActionLog.editCarSalon.start");

        CarSalonEntity existingCarSalon = carSalonsRepository.findById(carSalonId).orElse(null);
        if (existingCarSalon != null) {
            existingCarSalon.setTittle(carSalonDto.getTittle());
            existingCarSalon.setType(carSalonDto.getType());
            existingCarSalon.setDescription(carSalonDto.getDescription());
            existingCarSalon.setActiveTime(carSalonDto.getActiveTime());
            existingCarSalon.setRemark(carSalonDto.getRemark());
            existingCarSalon.setLogo(carSalonDto.getLogo());
            existingCarSalon.setImage(carSalonDto.getImage());
            existingCarSalon.setProductsCount(carSalonDto.getProductsCount());
            existingCarSalon.setViewNumber(carSalonDto.getViewNumber());
            existingCarSalon.setLocation(carSalonDto.getLocation());

            carSalonsRepository.saveAndFlush(existingCarSalon);
        }

        log.info("ActionLog.editCarSalon.end");
    }


    public void deleteCarSalon(Integer carSalonId) {
        log.info("ActionLog.deleteCarSalon.start");
        carSalonsRepository.deleteById(carSalonId);
        log.info("ActionLog.deleteCarSalon.end");
    }
}
