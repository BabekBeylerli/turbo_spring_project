package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.SubModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubModelRepository extends JpaRepository<SubModelEntity,Integer> {
}