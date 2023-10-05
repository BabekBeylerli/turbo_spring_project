package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.ProductDto;
import com.example.turbospringproject.model.ProductFilterDto;
import com.example.turbospringproject.model.ProductLiteDto;
import com.example.turbospringproject.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/public/filter")
    public Page<ProductLiteDto> getAllProductByFilter(Pageable pageable, ProductFilterDto productFilterDto) {
        return productService.getAllProductByFilter(pageable, productFilterDto);
    }

    @GetMapping("/public/{productId}")
    public ProductDto getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @PutMapping("")
    public void updateProduct(@RequestBody ProductDto productDto, Integer productId) {
        productService.editProduct(productDto, productId);
    }

    @DeleteMapping()
    @PreAuthorize("hasRole('USER')")
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }
}
