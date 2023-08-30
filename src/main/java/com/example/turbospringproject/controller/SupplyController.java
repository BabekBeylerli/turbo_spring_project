package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.SuppliesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/supplies")
public class SupplyController {
    private final SuppliesService suppliesService;

    public SupplyController(SuppliesService suppliesService) {
        this.suppliesService = suppliesService;
    }
}
