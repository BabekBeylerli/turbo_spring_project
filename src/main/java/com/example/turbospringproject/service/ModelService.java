package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.ModelRepository;
import com.example.turbospringproject.mapper.ModelMapper;
import com.example.turbospringproject.model.ModelDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Slf4j
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {

        this.modelRepository = modelRepository;
    }

    public List<ModelDto> getAllModel() {
        return ModelMapper.mapper.mapEntityToDtos(modelRepository.findAll());
    }
    public ModelDto getModel(Integer modelId){
        return ModelMapper.mapper.mapEntityToDto(modelRepository.findById(modelId).orElseThrow(()->
                new RuntimeException("Not Found")));
    }

    public void saveModel(ModelDto modelDto) {
        modelRepository.save(ModelMapper.mapper.mapDtoToEntity(modelDto));
    }

    public void editModel(ModelDto modelDto, Integer modelId) {
        modelRepository.save(ModelMapper.mapper.mapDtoToEntity(modelDto, modelId));
    }

    public void deleteModel(Integer modelId) {
        modelRepository.deleteById(modelId);
    }
}
