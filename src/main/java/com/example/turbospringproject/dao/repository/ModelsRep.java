package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelsRep extends JpaRepository<ModelEntity,Integer> {
}