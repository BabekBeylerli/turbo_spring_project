package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.ProductDto;
import com.example.turbospringproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("{productId}")
    public ProductDto getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto, Integer productId) {
        productService.editProduct(productDto, productId);
    }

    @DeleteMapping
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }
}
