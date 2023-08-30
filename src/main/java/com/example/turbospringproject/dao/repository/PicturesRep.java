package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicturesRep extends JpaRepository<PictureEntity, Integer> {
}