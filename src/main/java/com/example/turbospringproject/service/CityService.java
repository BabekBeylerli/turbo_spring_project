package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.CityRepository;
import com.example.turbospringproject.mapper.CityMapper;
import com.example.turbospringproject.model.CityDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    public List<CityDto> getAllCity(){
        return CityMapper.mapper.mapEntityToDtos(cityRepository.findAll());
    }
    public void saveCity(CityDto cityDto){
        cityRepository.save(CityMapper.mapper.mapDtoToEntity(cityDto));
    }
    public void editCity(CityDto cityDto,Integer cityId){
        cityRepository.save(CityMapper.mapper.mapDtoToEntity(cityDto,cityId));
    }
    public void deleteCity(Integer cityId){
        cityRepository.deleteById(cityId);
    }
}
