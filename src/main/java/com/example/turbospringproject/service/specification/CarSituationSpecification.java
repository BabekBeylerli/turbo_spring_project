package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.CarSituationEntity;
import com.example.turbospringproject.model.CarSituationFilterDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CarSituationSpecification implements Specification<CarSituationEntity> {
    private final CarSituationFilterDto carSituationFilterDto;

    public CarSituationSpecification(final CarSituationFilterDto carSituationFilterDto) {
        this.carSituationFilterDto = carSituationFilterDto;
    }

    @Override
    public Predicate toPredicate(Root<CarSituationEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (carSituationFilterDto.isStroke()) {
            predicates.add(criteriaBuilder.isTrue(root.get("stroke")));
        }

        if (carSituationFilterDto.isColored()) {
            predicates.add(criteriaBuilder.isTrue(root.get("colored")));
        }

        if (carSituationFilterDto.isAccident()) {
            predicates.add(criteriaBuilder.isTrue(root.get("accident")));
        }

        if (carSituationFilterDto.isCredit()) {
            predicates.add(criteriaBuilder.isTrue(root.get("credit")));
        }

        if (carSituationFilterDto.isBarter()) {
            predicates.add(criteriaBuilder.isTrue(root.get("barter")));
        }

        if (!predicates.isEmpty()) {
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }

        return null;
    }
}
