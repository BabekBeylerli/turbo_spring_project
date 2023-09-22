package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.BrandEntity;
import com.example.turbospringproject.dao.repository.BrandRepository;
import com.example.turbospringproject.mapper.BrandMapper;
import com.example.turbospringproject.model.BrandDto;
import com.example.turbospringproject.model.BrandFilterDto;
import com.example.turbospringproject.service.specification.BrandSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandsRepository) {
        this.brandRepository = brandsRepository;
    }

    public List<BrandDto> getAllBrand() {
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

    public List<BrandDto> getBrands(BrandFilterDto brandFilterDto) {
        log.info("ActionLog.getBrands.start");
        var specification = Specification.where(new BrandSpecification(brandFilterDto.getName()));
        var brands = brandRepository.findAll(specification).stream().map(BrandMapper.mapper::mapEntityToDto).collect(Collectors.toList());
        log.info("ActionLog.getBrands.end");
        return brands;
    }
}
