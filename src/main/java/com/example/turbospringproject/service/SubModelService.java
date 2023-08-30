package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.SubModelRep;

public class SubModelService {
    private final SubModelRep subModelRep;

    public SubModelService(SubModelRep subModelRep) {
        this.subModelRep = subModelRep;
    }
}
