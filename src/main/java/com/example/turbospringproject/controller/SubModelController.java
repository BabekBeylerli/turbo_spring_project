package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.SubModelDto;
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

    @GetMapping
    public List<SubModelDto> getAllSubModel() {
        return subModelService.getAllSubModel();
    }

    @GetMapping("{subModelId}")
    public SubModelDto getSubModel(@PathVariable Integer subModelId) {
        return subModelService.getSubModel(subModelId);
    }


    @PostMapping
    public void saveSubModel(@RequestBody SubModelDto subModelDto) {
        subModelService.saveSubModel(subModelDto);
    }

    @PutMapping
    public void updateSubModel(@RequestBody SubModelDto subModelDto, Integer subModelId) {
        subModelService.editSubModel(subModelDto, subModelId);
    }

    @DeleteMapping
    public void deleteSubModel(@PathVariable Integer subModelId) {
        subModelService.deleteSubModel(subModelId);
    }
}
