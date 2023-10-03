package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.dao.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
