package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.ProductsRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {
    private final ProductsRep productsRep;

    public ProductService(ProductsRep productsRep) {
        this.productsRep = productsRep;
    }
}
