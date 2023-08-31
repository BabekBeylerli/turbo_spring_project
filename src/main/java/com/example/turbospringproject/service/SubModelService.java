package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.SubModelRepository;
import com.example.turbospringproject.mapper.SubModelMapper;
import com.example.turbospringproject.model.SubModelDto;

import java.util.List;

public class SubModelService {
    private final SubModelRepository subModelRepository;


    public SubModelService(SubModelRepository subModelRepository) {
        this.subModelRepository = subModelRepository;
    }

    public List<SubModelDto> getAllSubModels() {
        return SubModelMapper.mapper.mapEntityToDtos(subModelRepository.findAll());
    }

    public SubModelDto getSubModel(Integer subModelId) {
        return SubModelMapper.mapper.mapEntityToDto(subModelRepository.findById(subModelId).orElseThrow(() ->
                new RuntimeException("Not Found")
        ));
    }

    public void saveSubModel(SubModelDto subModelDto) {
        subModelRepository.save(SubModelMapper.mapper.mapDtoToEntity(subModelDto));
    }

    public void editSubModel(SubModelDto subModelDto, Integer subModelId) {
        subModelRepository.save(SubModelMapper.mapper.mapDtoToEntity(subModelDto, subModelId));
    }

    public void deleteSubModel(Integer subModelId) {
        subModelRepository.deleteById(subModelId);
    }

}
