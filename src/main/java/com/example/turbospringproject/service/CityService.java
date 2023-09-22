package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.CityEntity;
import com.example.turbospringproject.dao.repository.CityRepository;
import com.example.turbospringproject.mapper.CityMapper;
import com.example.turbospringproject.model.CityDto;
import com.example.turbospringproject.model.CityFilterDto;
import com.example.turbospringproject.service.specification.CitySpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<CityDto> getCities(CityFilterDto cityFilterDto) {
        log.info("ActionLog.getCities.start");
        var specification = Specification.where(new CitySpecification(cityFilterDto.getName()));
        var cities = cityRepository.findAll(specification).stream().map(CityMapper.mapper::mapEntityToDto).collect(Collectors.toList());
        log.info("ActionLog.getAllCity.end");
        return cities;
    }
}
