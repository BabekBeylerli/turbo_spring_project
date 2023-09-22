package com.example.turbospringproject.dao.repository;


import com.example.turbospringproject.dao.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface SupplyRepository extends JpaRepository<SupplyEntity, Integer>, JpaSpecificationExecutor<SupplyEntity> {
}