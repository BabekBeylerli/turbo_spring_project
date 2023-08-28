package com.example.turbospringproject.dao.repositroies;


import com.example.turbospringproject.dao.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRep extends JpaRepository<Brands, Integer> {
}
