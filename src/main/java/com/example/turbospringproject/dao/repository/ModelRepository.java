package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.CityEntity;
import com.example.turbospringproject.dao.entity.ModelEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ModelRepository extends JpaRepository<ModelEntity, Integer>, JpaSpecificationExecutor<ModelEntity> {
    ModelEntity findByName(Specification<?> specification, String name);
}