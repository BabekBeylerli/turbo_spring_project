package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.dao.repository.ProductRepository;
import com.example.turbospringproject.mapper.ProductMapper;
import com.example.turbospringproject.model.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productsRepository;

    public ProductService(ProductRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    public List<ProductDto> getAllProducts() {
        return ProductMapper.mapper.mapEntityToDtos(productsRepository.findAll());
    }

    public ProductDto getProduct(Integer productId) {
        log.info("ActionLog.getProduct.start");
        ProductEntity productEntity =
                productsRepository.findById(productId).orElseThrow(() ->
                        new RuntimeException("Not Found!")
                );
        log.info("ActionLog.getProduct.end");
        return ProductMapper.mapper.mapEntityToDto(productEntity);
    }

    public void saveProduct(ProductDto productDto) {
        log.info("ActionLog.saveProduct.start");
        productsRepository.save(ProductMapper.mapper.mapDtoToEntity(productDto));
        log.info("ActionLog.saveProduct.end");
    }

    public void editProduct(ProductDto productDto, Integer productId) {
        log.info("ActionLog.editProduct.start");
        productsRepository.save(ProductMapper.mapper.mapDtoToEntity(productDto, productId));
        log.info("ActionLog.editProduct.end");
    }

    public void deleteProduct(Integer productId) {
        log.info("ActionLog.deleteProduct.start");
        productsRepository.deleteById(productId);
        log.info("ActionLog.deleteProduct.end");
    }
}
