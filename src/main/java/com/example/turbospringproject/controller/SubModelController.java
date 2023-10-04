package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.SubModelDto;
import com.example.turbospringproject.model.SubModelLiteDto;
import com.example.turbospringproject.service.SubModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subModel")

public class SubModelController {
    private final SubModelService subModelService;

    public SubModelController(SubModelService subModelService) {
        this.subModelService = subModelService;
    }

    @GetMapping("{subModelId}")
    public SubModelDto getSubModel(@PathVariable Integer subModelId) {
        return subModelService.getSubModel(subModelId);
    }


    @PostMapping
    public void saveSubModel(@RequestBody SubModelLiteDto subModelLiteDto) {
        subModelService.saveSubModel(subModelLiteDto);
    }
    @DeleteMapping("/{subModelId}")
    public void deleteSubModel(@PathVariable Integer subModelId) {
        subModelService.deleteSubModel(subModelId);
    }
}
