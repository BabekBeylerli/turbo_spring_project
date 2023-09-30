package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.SupplyDto;
import com.example.turbospringproject.model.SupplyFilterDto;
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
    public List<SupplyDto> getAllSupply( SupplyFilterDto supplyFilterDto) {
        return supplyService.getAllSupply(supplyFilterDto);
    }

    @GetMapping("{supplyId}")
    public SupplyDto getSupply(@PathVariable Integer supplyId) {
        return supplyService.getSupply(supplyId);
    }

    @PostMapping
    public void saveSupply(@RequestBody SupplyDto supplyDto) {
        supplyService.saveSupply(supplyDto);
    }

    @PutMapping
    public void updateSupply(@RequestBody SupplyDto supplyDto, @PathVariable Integer supplyId) {
        supplyService.editSupply(supplyDto, supplyId);
    }

    @DeleteMapping
    public void deleteSupply(@PathVariable Integer supplyId) {
        supplyService.deleteSupply(supplyId);
    }
}
