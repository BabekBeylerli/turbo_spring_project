package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.ModelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/models")
public class ModelController {
    private final ModelService modelsService;

    public ModelController(ModelService modelsService) {
        this.modelsService = modelsService;
    }
}
