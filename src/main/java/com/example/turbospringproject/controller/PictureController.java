package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.PictureDto;
import com.example.turbospringproject.service.PictureService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pictures")
public class PictureController {
    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping
    public List<PictureDto> getAllPicture() {
        return pictureService.getAllPicture();
    }

    @GetMapping("{pictureId}")
    public PictureDto getPicture(@PathVariable Integer pictureId) {
        return pictureService.getPicture(pictureId);
    }

    @PostMapping
    public void savePicture(@RequestBody PictureDto pictureDto) {
        pictureService.savePicture(pictureDto);
    }

    @PutMapping
    public void updatePicture(@RequestBody PictureDto pictureDto, @PathVariable Integer pictureId) {
        pictureService.editPicture(pictureDto, pictureId);
    }

    @DeleteMapping
    public void deletePicture(@PathVariable Integer pictureId) {
        pictureService.deletePicture(pictureId);
    }
}
