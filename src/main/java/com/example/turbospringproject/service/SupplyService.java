package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.SupplyEntity;
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

    public List<SupplyDto> getAllSupply() {
        log.info("ActionLog.getAllSupply.start");
        List<SupplyDto> supplyDtos =
                SupplyMapper.mapper.mapEntityToDtos(supplyRepository.findAll());
        log.info("ActionLog.getAllSupply.end");
        return supplyDtos;
    }


    public SupplyDto getSupply(Integer supplyId) {
        log.info("ActionLog.getSupply.start");
        SupplyEntity supplyEntity =
                supplyRepository.findById(supplyId).orElseThrow(() ->
                        new RuntimeException("Not Found")
                );
        log.info("ActionLog.getSupply.end");
        return SupplyMapper.mapper.mapEntityToDto(supplyEntity);
    }

    public void saveSupply(SupplyDto supplyDto) {
        log.info("ActionLog.saveSupply.start");
        supplyRepository.save(SupplyMapper.mapper.mapDtoToEntity(supplyDto));
        log.info("ActionLog.saveSupply.end");

    }

    public void editSupply(SupplyDto supplyDto, Integer supplyId) {
        log.info("ActionLog.editSupply.start");
        supplyRepository.save(SupplyMapper.mapper.mapDtoToEntity(supplyDto, supplyId));
        log.info("ActionLog.editSupply.end");
    }

    public void deleteSupply(Integer supplyId) {
        log.info("ActionLog.deleteSupply.start");
        supplyRepository.deleteById(supplyId);
        log.info("ActionLog.deleteSupply.end");
    }

}
