package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.ModelEntity;
import com.example.turbospringproject.dao.entity.SubModelEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SubModelSpecification implements Specification<SubModelEntity> {
    private final String name;

    public SubModelSpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<SubModelEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (name == null) {
            return null;
        }
        return criteriaBuilder.equal(root.<String>get("name"), name);
    }
}
