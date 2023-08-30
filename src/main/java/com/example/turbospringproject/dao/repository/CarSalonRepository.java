package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.CarSalonEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarSalonRepository extends JpaRepository<CarSalonEntity, Integer> {
}
