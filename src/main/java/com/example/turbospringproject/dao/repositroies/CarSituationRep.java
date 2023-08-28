package com.example.turbospringproject.dao.repositroies;

import com.example.turbospringproject.dao.entity.CarSituation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarSituationRep extends JpaRepository<CarSituation, Integer> {
}