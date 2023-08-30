package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.CarSituationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarSituationRepository extends JpaRepository<CarSituationEntity, Integer> {
}