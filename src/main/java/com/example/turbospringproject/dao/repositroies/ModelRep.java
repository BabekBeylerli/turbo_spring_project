package com.example.turbospringproject.dao.repositroies;

import com.example.turbospringproject.dao.entity.Models;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRep extends JpaRepository<Models,Integer> {
}