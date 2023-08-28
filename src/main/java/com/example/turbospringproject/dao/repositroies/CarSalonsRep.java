package com.example.turbospringproject.dao.repositroies;

import com.example.turbospringproject.dao.entity.CarSalons;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarSalonsRep extends JpaRepository<CarSalons, Integer> {
}
