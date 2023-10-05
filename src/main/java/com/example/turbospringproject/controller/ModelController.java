package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.*;
import com.example.turbospringproject.service.ModelService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
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
    @PostMapping("/admin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void saveModel(@RequestBody ModelLiteDto modelDto) {
        modelService.saveModel(modelDto);
    }
    @DeleteMapping("/admin/{modelId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteModel(@PathVariable Integer modelId) {
        modelService.deleteModel(modelId);
    }
}
