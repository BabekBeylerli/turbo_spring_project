package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.SubModelRepository;

public class SubModelService {
    private final SubModelRepository subModelRep;

    public SubModelService(SubModelRepository subModelRep) {
        this.subModelRep = subModelRep;
    }
}
