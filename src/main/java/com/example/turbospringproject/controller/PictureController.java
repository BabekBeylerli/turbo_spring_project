package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.PictureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pictures")
public class PictureController {
private final PictureService picturesService;

    public PictureController(PictureService picturesService) {
        this.picturesService = picturesService;
    }
}
