package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.PicturesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pictures")
public class PicturesController {
private final PicturesService picturesService;

    public PicturesController(PicturesService picturesService) {
        this.picturesService = picturesService;
    }
}
