package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PictureRepository extends JpaRepository<PictureEntity, Integer>, JpaSpecificationExecutor<PictureEntity> {
}