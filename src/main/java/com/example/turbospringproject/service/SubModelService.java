package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.SubModelEntity;
import com.example.turbospringproject.dao.repository.SubModelRepository;
import com.example.turbospringproject.mapper.SubModelMapper;
import com.example.turbospringproject.model.SubModelDto;
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

    public List<SubModelDto> getAllSubModel() {
        log.info("ActionLog.getAllSubModel.start");
        List<SubModelDto> subModelDtos =
                SubModelMapper.mapper.mapEntityToDtos(subModelRepository.findAll());
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

}
