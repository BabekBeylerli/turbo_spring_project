package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}