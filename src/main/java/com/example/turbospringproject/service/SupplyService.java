package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.SupplyRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SupplyService {
    private final SupplyRep suppliesRep;

    public SupplyService(SupplyRep suppliesRep) {
        this.suppliesRep = suppliesRep;
    }
}
