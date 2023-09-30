package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.*;
import com.example.turbospringproject.service.ModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/models")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<ModelDto> getAllModel() {
        return modelService.getAllModel();
    }

    @GetMapping("{modelId}")
    public ModelDto getModel(@PathVariable Integer modelId) {
        return modelService.getModel(modelId);
    }

    @PostMapping
    public void saveModel(@RequestBody ModelDto modelDto) {
        modelService.saveModel(modelDto);
    }

    @PutMapping
    public void updateModel(@RequestBody ModelDto modelDto, @PathVariable Integer modelId) {
        modelService.editModel(modelDto, modelId);
    }

    @DeleteMapping
    public void deleteModel(@PathVariable Integer modelId) {
        modelService.deleteModel(modelId);
    }

    @GetMapping("filter")
    public ModelDto getModels(ModelFilterDto modelFilterDto) {
        return modelService.getModels(modelFilterDto);
    }
}
