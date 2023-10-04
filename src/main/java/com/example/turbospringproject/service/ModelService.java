package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.ModelEntity;
import com.example.turbospringproject.dao.repository.ModelRepository;
import com.example.turbospringproject.mapper.ModelMapper;
import com.example.turbospringproject.model.ModelDto;
import com.example.turbospringproject.model.ModelLiteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void saveModel(ModelLiteDto modelDto) {
        log.info("ActionLog.saveModel.start");
        modelRepository.save(ModelMapper.mapper.mapDtoToEntity(modelDto));
        log.info("ActionLog.saveModel.end");
    }



    public void deleteModel(Integer modelId) {
        log.info("ActionLog.deleteModel.start");
        modelRepository.deleteById(modelId);
        log.info("ActionLog.deleteModel.end");
    }

}
