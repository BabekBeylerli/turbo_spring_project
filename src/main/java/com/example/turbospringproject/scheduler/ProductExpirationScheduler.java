package com.example.turbospringproject.scheduler;

import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.dao.entity.enums.ProductActiveStatus;
import com.example.turbospringproject.dao.repository.ProductRepository;
import com.example.turbospringproject.service.ProductService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class ProductExpirationScheduler {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductExpirationScheduler(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }
    @Scheduled(cron = "0 0 0 * * ?")
    public void expireProducts() {
        List<ProductEntity> productEntities=productRepository.findAll();
        for (ProductEntity product:productEntities) {
            LocalDateTime createdAt = product.getCreatedAt();
            LocalDateTime now = LocalDateTime.now();
            long daysDifference = ChronoUnit.DAYS.between(createdAt.toLocalDate(), now.toLocalDate());
            if(daysDifference>15){
                product.setProductActiveStatus(ProductActiveStatus.EXPIRED);
            }
            productRepository.save(product);
        }
    }
}
