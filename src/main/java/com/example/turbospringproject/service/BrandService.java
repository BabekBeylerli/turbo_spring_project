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
        return BrandMapper.mapper.mapEntityToDtos(brandRepository.findAll());
    }

    public BrandDto getBrand(Integer brandId) {
        return BrandMapper.mapper.mapEntityToDto(brandRepository.findById(brandId).orElseThrow(() ->
                new RuntimeException("Not Found")
        ));
    }

    public void saveBrand(BrandDto brandDto) {
        brandRepository.save(BrandMapper.mapper.mapDtoToEntity(brandDto));
    }

    public void editBrand(BrandDto brandDto, Integer brandId) {
        brandRepository.save(BrandMapper.mapper.mapDtoToEntity(brandDto, brandId));
    }

    public void deleteBrand(Integer brandId) {
        brandRepository.deleteById(brandId);
    }
}
