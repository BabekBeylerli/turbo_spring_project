package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.dao.repository.ProductsRep;
import com.example.turbospringproject.mapper.ProductMapper;
import com.example.turbospringproject.model.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductsRep productsRep;

    public ProductService(ProductsRep productsRep) {
        this.productsRep = productsRep;
    }

    public List<ProductDto> getAllProducts(){
        return ProductMapper.mapper.mapEntityToDtos(productsRep.findAll());
    }
}
