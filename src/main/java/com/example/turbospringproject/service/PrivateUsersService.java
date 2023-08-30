package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.PrivateUsersRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrivateUsersService {
private final PrivateUsersRep privateUsersRep;

    public PrivateUsersService(PrivateUsersRep privateUsersRep) {
        this.privateUsersRep = privateUsersRep;
    }
}
