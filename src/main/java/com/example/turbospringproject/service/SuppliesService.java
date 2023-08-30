package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.SuppliesRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SuppliesService {
    private final SuppliesRep suppliesRep;

    public SuppliesService(SuppliesRep suppliesRep) {
        this.suppliesRep = suppliesRep;
    }
}
