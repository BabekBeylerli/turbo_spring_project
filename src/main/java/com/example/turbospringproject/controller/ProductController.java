package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.ProductDto;
import com.example.turbospringproject.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productsService;

    public ProductController(ProductService productsService) {

        this.productsService = productsService;

    }
    @GetMapping("/get")
    public List<ProductDto> getAllProducts(){
        return productsService.getAllProducts();
    }
}
