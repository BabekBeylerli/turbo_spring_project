package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.ModelsRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ModelsService {
    private final ModelsRep modelsRep;

    public ModelsService(ModelsRep modelsRep) {
        this.modelsRep = modelsRep;
    }
}
