package com.example.turbospringproject.service;

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
        return ProductMapper.mapper.mapEntityToDto(productsRepository.findById(productId).orElseThrow(() ->
                new RuntimeException("Not Found!")));
    }

    public void saveProduct(ProductDto productDto) {
        productsRepository.save(ProductMapper.mapper.mapDtoToEntity(productDto));
    }

    public void editProduct(ProductDto productDto, Integer productId) {
        productsRepository.save(ProductMapper.mapper.mapDtoToEntity(productDto, productId));
    }

    public void deleteProduct(Integer productId) {
        productsRepository.deleteById(productId);
    }
}
