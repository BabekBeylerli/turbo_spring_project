package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.BrandEntity;
import com.example.turbospringproject.dao.repository.BrandRepository;
import com.example.turbospringproject.mapper.BrandMapper;
import com.example.turbospringproject.model.BrandDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandsRepository) {
        this.brandRepository = brandsRepository;
    }

    public List<BrandDto> getAllBrands() {
        log.info("ActionLog.getAllBrands.start");
        List<BrandDto> brandDtos = BrandMapper.mapper.mapEntityToDtos(brandRepository.findAll());
        log.info("ActionLog.getAllBrands.end");
        return brandDtos;
    }

    public BrandDto getBrand(Integer brandId) {
        log.info("ActionLog.getBrand.start");
        BrandEntity brandEntity =
                brandRepository.findById(brandId).orElseThrow(() ->
                        new RuntimeException("Not Found")

                );
        log.info("ActionLog.getBrand.end");
        return BrandMapper.mapper.mapEntityToDto(brandEntity);
    }

    public void saveBrand(BrandDto brandDto) {
        log.info("ActionLog.saveBrand.start");
        brandRepository.save(BrandMapper.mapper.mapDtoToEntity(brandDto));
        log.info("ActionLog.saveBrand.end");
    }

    public void editBrand(BrandDto brandDto, Integer brandId) {
        log.info("ActionLog.editBrand.start");
        brandRepository.save(BrandMapper.mapper.mapDtoToEntity(brandDto, brandId));
        log.info("ActionLog.editBrand.end4");
    }

    public void deleteBrand(Integer brandId) {
        log.info("ActionLog.deleteBrand.start");
        brandRepository.deleteById(brandId);
        log.info("ActionLog.deleteBrand.end");
    }
}
