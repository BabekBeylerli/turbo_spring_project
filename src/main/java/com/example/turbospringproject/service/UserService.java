package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
private final UserRepository privateUsersRep;

    public UserService(UserRepository privateUsersRep) {
        this.privateUsersRep = privateUsersRep;
    }
}
