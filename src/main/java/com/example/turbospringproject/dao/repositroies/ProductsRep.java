package com.example.turbospringproject.dao.repositroies;

import com.example.turbospringproject.dao.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRep extends JpaRepository<Products, Integer> {
}