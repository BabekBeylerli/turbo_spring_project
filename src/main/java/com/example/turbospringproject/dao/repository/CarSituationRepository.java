package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.CarSituationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CarSituationRepository extends JpaRepository<CarSituationEntity, Integer>, JpaSpecificationExecutor<CarSituationEntity> {
}