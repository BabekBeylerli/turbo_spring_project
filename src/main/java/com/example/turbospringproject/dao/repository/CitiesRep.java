package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRep extends JpaRepository<CityEntity,Integer> {
}