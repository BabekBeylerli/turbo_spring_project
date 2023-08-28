package com.example.turbospringproject.dao.repositroies;

import com.example.turbospringproject.dao.entity.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicturesRep extends JpaRepository<Pictures, Integer> {
}