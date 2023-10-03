package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.BrandEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BrandSpecification implements Specification<BrandEntity> {

    private final String name;

    public BrandSpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<BrandEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (name == null || name.isEmpty()) {
            return null; // Filtre boşsa hiçbir şey yapma
        }
        return criteriaBuilder.like(root.get("name"), name);
    }

}
