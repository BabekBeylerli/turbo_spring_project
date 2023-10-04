package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.SupplyDto;
import com.example.turbospringproject.service.SupplyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/supplies")
public class SupplyController {
    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping
    public List<SupplyDto> getAllSupply() {
        return supplyService.getAllSupply();
    }


}
