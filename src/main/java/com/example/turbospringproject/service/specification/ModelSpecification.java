package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.ModelEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ModelSpecification implements Specification<ModelEntity> {
    private final String name;

    public ModelSpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<ModelEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (name == null) {
            return null;
        }
        return criteriaBuilder.equal(root.<String>get("name"), name);
    }
}
