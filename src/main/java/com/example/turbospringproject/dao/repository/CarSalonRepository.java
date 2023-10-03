package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.CarSalonEntity;
import com.example.turbospringproject.dao.entity.enums.ECarSalon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface CarSalonRepository extends JpaRepository<CarSalonEntity, Integer>, JpaSpecificationExecutor<CarSalonEntity> {
    List<CarSalonEntity> findAllByType(ECarSalon type);
}
