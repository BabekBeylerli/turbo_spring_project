package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.ModelsRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ModelService {
    private final ModelsRep modelsRep;

    public ModelService(ModelsRep modelsRep) {
        this.modelsRep = modelsRep;
    }
}
