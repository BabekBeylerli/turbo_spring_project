package com.example.turbospringproject.dao.repository;


import com.example.turbospringproject.dao.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
}
