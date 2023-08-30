package com.example.turbospringproject.controller;

import com.example.turbospringproject.service.SupplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/supplies")
public class SupplyController {
    private final SupplyService suppliesService;

    public SupplyController(SupplyService suppliesService) {
        this.suppliesService = suppliesService;
    }
}
