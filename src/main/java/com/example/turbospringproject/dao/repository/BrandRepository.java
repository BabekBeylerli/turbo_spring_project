package com.example.turbospringproject.dao.repository;


import com.example.turbospringproject.dao.entity.BrandEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntitiy, Integer> {
}
