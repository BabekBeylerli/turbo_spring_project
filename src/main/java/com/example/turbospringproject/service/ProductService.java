package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.dao.repository.ProductRepository;
import com.example.turbospringproject.mapper.ProductMapper;
import com.example.turbospringproject.model.ProductDto;
import com.example.turbospringproject.model.ProductFilterDto;
import com.example.turbospringproject.model.ProductLiteDto;
import com.example.turbospringproject.service.specification.ProductSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.turbospringproject.mapper.ProductMapper.*;
import static org.apache.commons.lang3.Streams.stream;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productsRepository;

    public ProductService(ProductRepository productsRepository) {
        this.productsRepository = productsRepository;

    }
    public Page<ProductLiteDto> getAllProductByFilter(Pageable pageable, ProductFilterDto productFilterDto) {
        Specification<ProductEntity> specification = new ProductSpecification(productFilterDto);
        Sort sort = Sort.by(Sort.Order.desc("eProduct"));

        Pageable pageableWithSorting = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                sort
        );
        Page<ProductEntity> productPage = productsRepository.findAll(specification, pageableWithSorting);
        List<ProductLiteDto> productLiteDtos = ProductMapper.mapper.mapEntityToLiteDtos2(productPage.getContent());

        return new PageImpl<>(productLiteDtos, pageable, productPage.getTotalElements());
    }

    public List<ProductLiteDto> getAllProduct(){
        return ProductMapper.mapper.mapEntityToLiteDtos2(productsRepository.findAll());
    }
    public ProductDto getProduct(Integer productId) {
        log.info("ActionLog.getProduct.start");
        ProductEntity productEntity =
                productsRepository.findById(productId).orElseThrow(() ->
                        new RuntimeException("Not Found!")
                );
        int currentViewNumber = productEntity.getViewCount();
        productEntity.setViewCount(currentViewNumber + 1);
        productsRepository.save(productEntity);
        log.info("ActionLog.getProduct.end");
        return  ProductMapper.mapper.mapEntityToDto(productEntity);
    }


    public void saveProduct(ProductDto productDto) {
        log.info("ActionLog.saveProduct.start");
        productsRepository.save(mapper.mapDtoToEntity(productDto));
        log.info("ActionLog.saveProduct.end");
    }

    public void editProduct(ProductDto productDto, Integer productId) {
        log.info("ActionLog.editProduct.start");

        // productId ile var olan ProductEntity'yi alın
        ProductEntity existingProduct = productsRepository.findById(productId).orElse(null);

        if (existingProduct != null) {
            existingProduct.setEProduct(productDto.getEProduct());
            existingProduct.setBanType(productDto.getBanType());
            existingProduct.setMarch(productDto.getMarch());
            existingProduct.setMarchType(productDto.getMarchType());
            existingProduct.setColor(productDto.getColor());
            existingProduct.setPrice(productDto.getPrice());
            existingProduct.setPriceType(productDto.getPriceType());
            existingProduct.setOwners(productDto.getOwners());
            existingProduct.setFuelType(productDto.getFuelType());
            existingProduct.setGear(productDto.getGear());
            existingProduct.setGearBox(productDto.getGearBox());
            existingProduct.setYear(productDto.getYear());
            existingProduct.setEngineVolume(productDto.getEngineVolume());
            existingProduct.setEnginePower(productDto.getEnginePower());
            existingProduct.setMarket(productDto.getMarket());
            existingProduct.setSeatsNumber(productDto.getSeatsNumber());
            existingProduct.setVinCode(productDto.getVinCode());
            existingProduct.setDescription(productDto.getDescription());
            existingProduct.setViewCount(productDto.getViewCount());
            existingProduct.setProductActiveStatus(productDto.getActiveStatus());

            productsRepository.saveAndFlush(existingProduct);
        }

        log.info("ActionLog.editProduct.end");
    }


    public void deleteProduct(Integer productId) {
        log.info("ActionLog.deleteProduct.start");
        productsRepository.deleteById(productId);
        log.info("ActionLog.deleteProduct.end");
    }
}
