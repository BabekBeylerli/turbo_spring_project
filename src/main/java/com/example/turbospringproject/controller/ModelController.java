package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.ModelsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/models")
public class ModelController {
    private final ModelsService modelsService;

    public ModelController(ModelsService modelsService) {
        this.modelsService = modelsService;
    }
}
