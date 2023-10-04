package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.CityEntity;
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

    public List<CityDto> getAllCity() {
        log.info("ActionLog.getAllCity.start");
        List<CityDto> cityDtos =
                CityMapper.mapper.mapEntityToDtos(cityRepository.findAll());
        log.info("ActionLog.getAllCity.end");
        return cityDtos;
    }

    public CityDto getCity(Integer cityId) {
        log.info("ActionLog.getCity.start");
        CityEntity cityEntity =
                cityRepository.findById(cityId).orElseThrow(() ->
                        new RuntimeException("Not found")
                );
        log.info("ActionLog.getCity.end");
        return CityMapper.mapper.mapEntityToDto(cityEntity);

    }

    public void saveCity(CityDto cityDto) {
        log.info("ActionLog.saveCity.start");
        cityRepository.save(CityMapper.mapper.mapDtoToEntity(cityDto));
        log.info("ActionLog.saveCity.end");
    }

    public void editCity(CityDto cityDto, Integer cityId) {
        log.info("ActionLog.editCity.start");
        cityRepository.save(CityMapper.mapper.mapDtoToEntity(cityDto, cityId));
        log.info("ActionLog.editCity.end");
    }

    public void deleteCity(Integer cityId) {
        log.info("ActionLog.deleteCity.start");
        cityRepository.deleteById(cityId);
        log.info("ActionLog.deleteCity.end");
    }


}
