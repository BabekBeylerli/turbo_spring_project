package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.PictureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/pictures")
public class PictureController {
    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllPictures() {
        List<String> base64Images = pictureService.getAllPictures();
        return new ResponseEntity<>(base64Images, HttpStatus.OK);
    }

    @GetMapping("/{pictureId}")
    public ResponseEntity<String> getPicture(@PathVariable Integer pictureId) {
        String base64Image = pictureService.getPicture(pictureId);
        return new ResponseEntity<>(base64Image, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> savePicture(@RequestBody String base64Image) {
        pictureService.savePicture(base64Image);
        return new ResponseEntity<>("Picture saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{pictureId}")
    public ResponseEntity<String> updatePicture(@PathVariable Integer pictureId, @RequestBody String base64Image) {
        pictureService.updatePicture(base64Image, pictureId);
        return new ResponseEntity<>("Picture updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{pictureId}")
    public ResponseEntity<String> deletePicture(@PathVariable Integer pictureId) {
        pictureService.deletePicture(pictureId);
        return new ResponseEntity<>("Picture deleted successfully", HttpStatus.NO_CONTENT);
    }
}
