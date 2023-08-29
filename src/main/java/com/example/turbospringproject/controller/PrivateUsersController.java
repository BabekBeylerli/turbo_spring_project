package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.PrivateUsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/privateUsers")
public class PrivateUsersController {
    private final PrivateUsersService privateUsersService;

    public PrivateUsersController(PrivateUsersService privateUsersService) {
        this.privateUsersService = privateUsersService;
    }
}
