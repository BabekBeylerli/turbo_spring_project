package com.example.turbospringproject.dao.repository;


import com.example.turbospringproject.dao.entity.BrandEntity;
import com.example.turbospringproject.model.BrandDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<BrandEntity, Integer>, JpaSpecificationExecutor<BrandEntity> {
    BrandEntity findByName(Specification<?> specification, String name);
}
