package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrandsService {
private final BrandRepository brandsRep;

    public BrandsService(BrandRepository brandsRep) {
        this.brandsRep = brandsRep;
    }
}
