package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.BrandRepository;
import com.example.turbospringproject.dao.repository.CarSalonRepository;
import com.example.turbospringproject.mapper.BrandMapper;
import com.example.turbospringproject.mapper.CarSalonMapper;
import com.example.turbospringproject.model.BrandDto;
import com.example.turbospringproject.model.CarSalonDto;
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
    public List<CarSalonDto> getAllCarSalon(){
        return CarSalonMapper.mapper.mapEntityToDtos(carSalonsRepository.findAll());
    }
    public CarSalonDto getCarSalon(Integer carSalonId){
        return CarSalonMapper.mapper.mapEntityToDto(carSalonsRepository.findById(carSalonId).orElseThrow(()->
                new RuntimeException("NotFound")
        ));
    }
    public void saveCarSalon(CarSalonDto carSalonDto){
        carSalonsRepository.save(CarSalonMapper.mapper.mapDtoToEntity(carSalonDto));
    }
    public void editCarSalon(CarSalonDto carSalonDto,Integer carSalonId){
        carSalonsRepository.save(CarSalonMapper.mapper.mapDtoToEntity(carSalonDto,carSalonId));
    }
    public void deleteCarSalon(Integer carSalonId){
        carSalonsRepository.deleteById(carSalonId);
    }
}
