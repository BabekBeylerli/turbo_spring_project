package com.example.turbospringproject.service;

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
    public List<CarSalonPhoneDto> getAllCarSalonPhone(){
        return CarSalonPhoneMapper.mapper.mapEntityToDtos(carSalonPhoneRepository.findAll());
    }
    public CarSalonPhoneDto getCarSalonPhone(Integer carSalonPhoneId){
        return CarSalonPhoneMapper.mapper.mapEntityToDto(carSalonPhoneRepository.findById(carSalonPhoneId).orElseThrow(()->
                new RuntimeException("NotFound")
        ));
    }
    public void saveCarSalonPhone(CarSalonPhoneDto carSalonPhoneDto){
        carSalonPhoneRepository.save(CarSalonPhoneMapper.mapper.mapDtoToEntity(carSalonPhoneDto));
    }
    public void editCarSalonPhone(CarSalonPhoneDto carSalonPhoneDto,Integer carSalonPhoneId){
        carSalonPhoneRepository.save(CarSalonPhoneMapper.mapper.mapDtoToEntity(carSalonPhoneDto,carSalonPhoneId));
    }
    public void deleteCarSalonPhone(Integer carSalonPhoneId){
        carSalonPhoneRepository.deleteById(carSalonPhoneId);
    }

}
