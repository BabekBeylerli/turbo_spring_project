package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.CityEntity;
import com.example.turbospringproject.dao.entity.SubModelEntity;
import com.example.turbospringproject.dao.repository.SubModelRepository;
import com.example.turbospringproject.mapper.CityMapper;
import com.example.turbospringproject.mapper.SubModelMapper;
import com.example.turbospringproject.model.CityDto;
import com.example.turbospringproject.model.CityFilterDto;
import com.example.turbospringproject.model.SubModelDto;
import com.example.turbospringproject.model.SubModelFilterDto;
import com.example.turbospringproject.service.specification.CitySpecification;
import com.example.turbospringproject.service.specification.SubModelSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class SubModelService {
    private final SubModelRepository subModelRepository;


    public SubModelService(SubModelRepository subModelRepository) {
        this.subModelRepository = subModelRepository;
    }

    public List<SubModelDto> getAllSubModel(SubModelFilterDto subModelFilterDto) {
        log.info("ActionLog.getAllSubModel.start");
        var specification = Specification.where(new SubModelSpecification(subModelFilterDto.getName()));
        List<SubModelDto> subModelDtos = SubModelMapper.mapper.mapEntityToDtos(subModelRepository.findAll(specification));
        log.info("ActionLog.getAllSubModel.end");
        return subModelDtos;
    }

    public SubModelDto getSubModel(Integer subModelId) {
        log.info("ActionLog.getSubModel.start");
        SubModelEntity subModelEntity =
                subModelRepository.findById(subModelId).orElseThrow(() ->
                        new RuntimeException("Not Found")
                );
        log.info("ActionLog.getSubModel.end");
        return SubModelMapper.mapper.mapEntityToDto(subModelEntity);
    }

    public void saveSubModel(SubModelDto subModelDto) {
        log.info("ActionLog.saveSubModel.start");
        subModelRepository.save(SubModelMapper.mapper.mapDtoToEntity(subModelDto));
        log.info("ActionLog.saveSubModel.end");
    }

    public void editSubModel(SubModelDto subModelDto, Integer subModelId) {
        log.info("ActionLog.editSubModel.start");
        subModelRepository.save(SubModelMapper.mapper.mapDtoToEntity(subModelDto, subModelId));
        log.info("ActionLog.editSubModel.end");
    }

    public void deleteSubModel(Integer subModelId) {
        log.info("ActionLog.deleteSubModel.start");
        subModelRepository.deleteById(subModelId);
        log.info("ActionLog.deleteSubModel.end");
    }
//    public SubModelDto getFilterSubModel(SubModelFilterDto subModelFilterDto) {
//        log.info("ActionLog.getSubModels.start");
//        var specification = Specification.where(new CitySpecification(subModelFilterDto.getName()));
//        SubModelEntity subModelEntity = subModelRepository.findByName(specification, subModelFilterDto.getName());
//        SubModelDto subModelDto= SubModelMapper.mapper.mapEntityToDto(subModelEntity);
//        log.info("ActionLog.getSubModels.end");
//        return subModelDto;
//    }

}
