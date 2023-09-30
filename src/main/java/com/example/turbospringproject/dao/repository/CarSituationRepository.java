package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.CarSituationEntity;
import com.example.turbospringproject.model.CarSituationDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface CarSituationRepository extends JpaRepository<CarSituationEntity, Integer>, JpaSpecificationExecutor<CarSituationEntity> {
    List<CarSituationDto> findByStrokeAndColoredAndAccidentAndCreditAndBarter(boolean isStroke, boolean isColored, boolean isAccident, boolean isCredit, boolean isBarter);
}

