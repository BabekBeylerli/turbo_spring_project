package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {

        this.modelRepository = modelRepository;
    }
}
