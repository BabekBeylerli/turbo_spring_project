package com.example.turbospringproject.dao.repositroies;


import com.example.turbospringproject.dao.entity.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SuppliesRep extends JpaRepository<Supplies, Integer> {
}