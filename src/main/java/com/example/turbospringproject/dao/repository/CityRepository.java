package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.BrandEntity;
import com.example.turbospringproject.dao.entity.CityEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<CityEntity, Integer>, JpaSpecificationExecutor<CityEntity> {
    CityEntity findByName(Specification<?> specification, String name);
}
