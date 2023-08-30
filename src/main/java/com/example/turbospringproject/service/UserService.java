package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.UserRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
private final UserRep privateUsersRep;

    public UserService(UserRep privateUsersRep) {
        this.privateUsersRep = privateUsersRep;
    }
}
