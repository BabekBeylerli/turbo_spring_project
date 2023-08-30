package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.PicturesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pictures")
public class PictureController {
private final PicturesService picturesService;

    public PictureController(PicturesService picturesService) {
        this.picturesService = picturesService;
    }
}
