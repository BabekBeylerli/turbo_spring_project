package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.ModelEntity;
import com.example.turbospringproject.dao.repository.ModelRepository;
import com.example.turbospringproject.mapper.ModelMapper;
import com.example.turbospringproject.model.ModelDto;
import com.example.turbospringproject.model.ModelFilterDto;
import com.example.turbospringproject.service.specification.ModelSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {

        this.modelRepository = modelRepository;
    }

    public List<ModelDto> getAllModel() {
        log.info("ActionLog.getAllModel.start");
        List<ModelDto> modelDtos =
                ModelMapper.mapper.mapEntityToDtos(modelRepository.findAll());
        log.info("ActionLog.getAllModel.end");
        return modelDtos;
    }

    public ModelDto getModel(Integer modelId) {
        log.info("ActionLog.getModel.start");
        ModelEntity modelEntity =
                modelRepository.findById(modelId).orElseThrow(() ->
                        new RuntimeException("Not Found")
                );
        log.info("ActionLog.getModel.end");
        return ModelMapper.mapper.mapEntityToDto(modelEntity);
    }

    public void saveModel(ModelDto modelDto) {
        log.info("ActionLog.saveModel.start");
        modelRepository.save(ModelMapper.mapper.mapDtoToEntity(modelDto));
        log.info("ActionLog.saveModel.end");
    }

    public void editModel(ModelDto modelDto, Integer modelId) {
        log.info("ActionLog.editModel.start");
        modelRepository.save(ModelMapper.mapper.mapDtoToEntity(modelDto, modelId));
        log.info("ActionLog.editModel.end");
    }

    public void deleteModel(Integer modelId) {
        log.info("ActionLog.deleteModel.start");
        modelRepository.deleteById(modelId);
        log.info("ActionLog.deleteModel.end");
    }

    public List<ModelDto> getModels(ModelFilterDto modelFilterDto) {
        log.info("ActionLog.getModels.start");
        var specification = Specification.where(new ModelSpecification(modelFilterDto.getName()));
        var models = modelRepository.findAll(specification).stream().map(ModelMapper.mapper::mapEntityToDto).collect(Collectors.toList());
        log.info("ActionLog.getModels.end");
        return models;
    }
}
