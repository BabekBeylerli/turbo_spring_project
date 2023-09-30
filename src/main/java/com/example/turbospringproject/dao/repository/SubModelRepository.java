package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.ModelEntity;
import com.example.turbospringproject.dao.entity.SubModelEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubModelRepository extends JpaRepository<SubModelEntity, Integer>, JpaSpecificationExecutor<SubModelEntity> {

}
