package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.CarSalonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CarSalonRepository extends JpaRepository<CarSalonEntity, Integer>, JpaSpecificationExecutor<CarSalonEntity> {
}
