package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/privateUsers")
public class UserController {
    private final UserService privateUsersService;

    public UserController(UserService privateUsersService) {
        this.privateUsersService = privateUsersService;
    }
}
