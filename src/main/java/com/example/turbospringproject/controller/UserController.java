package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.UserDto;
import com.example.turbospringproject.service.UserService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/privateUsers")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/get")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public UserDto getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDto userDto, Integer userId) {
        userService.editUser(userDto, userId);
    }
    @DeleteMapping
    public void deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
    }
}
