package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.BrandEntity;
import com.example.turbospringproject.dao.repository.BrandRepository;
import com.example.turbospringproject.mapper.BrandMapper;
import com.example.turbospringproject.model.BrandDto;
import com.example.turbospringproject.model.BrandLiteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandsRepository) {
        this.brandRepository = brandsRepository;
    }

    public List<BrandLiteDto> getAllBrand() {
        log.info("ActionLog.getAllBrands.start");
        List<BrandLiteDto> brandLiteDtos = BrandMapper.mapper.mapEntityToDtos2(brandRepository.findAll());
        log.info("ActionLog.getAllBrands.end");
        return brandLiteDtos;
    }
 //   public BrandLiteDto

    public BrandDto getBrand(Integer brandId) {
        log.info("ActionLog.getBrand.start");
        BrandEntity brandEntity =
                brandRepository.findById(brandId).orElseThrow(() ->
                        new RuntimeException("Not Found")

                );
        log.info("ActionLog.getBrand.end");
        return BrandMapper.mapper.mapEntityToDto(brandEntity);
    }
    public BrandDto getBrandByName(String name){
        return BrandMapper.mapper.mapEntityToDto(brandRepository.findByName(name));
    }

    public void saveBrand(BrandLiteDto brandLiteDto) {
        log.info("ActionLog.saveBrand.start");
        brandRepository.save(BrandMapper.mapper.mapDtoToEtity2(brandLiteDto));
        log.info("ActionLog.saveBrand.end");
    }

    public void deleteBrand(Integer brandId) {
        log.info("ActionLog.deleteBrand.start");
        brandRepository.deleteById(brandId);
        log.info("ActionLog.deleteBrand.end");
    }

}
