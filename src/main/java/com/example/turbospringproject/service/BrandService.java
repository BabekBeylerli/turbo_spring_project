package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrandService {
private final BrandRepository brandsRep;

    public BrandService(BrandRepository brandsRep) {
        this.brandsRep = brandsRep;

    }
}
