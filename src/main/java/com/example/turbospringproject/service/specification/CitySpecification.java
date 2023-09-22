package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.CityEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class CitySpecification implements Specification<CityEntity> {
private final String name;

    public CitySpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<CityEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (name == null) {
            return null;
        }
        return criteriaBuilder.equal(root.<String>get("name"),name);
    }
}
