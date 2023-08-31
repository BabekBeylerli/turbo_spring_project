package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.SupplyRepository;
import com.example.turbospringproject.mapper.SupplyMapper;
import com.example.turbospringproject.model.SupplyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SupplyService {
    private final SupplyRepository supplyRepository;

    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public List<SupplyDto> getAllSupplies() {
        return SupplyMapper.mapper.mapEntityToDtos(supplyRepository.findAll());
    }

    public SupplyDto getSupply(Integer supplyId) {
        return SupplyMapper.mapper.mapEntityToDto(supplyRepository.findById(supplyId).orElseThrow(() ->
                new RuntimeException("Not Found"))
        );
    }

    public void saveSupply(SupplyDto supplyDto) {
        supplyRepository.save(SupplyMapper.mapper.mapDtoToEntity(supplyDto));
    }

    public void editSupply(SupplyDto supplyDto, Integer supplyId) {
        supplyRepository.save(SupplyMapper.mapper.mapDtoToEntity(supplyDto, supplyId));
    }

    public void deleteSupply(Integer supplyId) {
        supplyRepository.deleteById(supplyId);
    }

}
