package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.SupplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SupplyService {
    private final SupplyRepository suppliesRep;

    public SupplyService(SupplyRepository suppliesRep) {
        this.suppliesRep = suppliesRep;
    }
}
