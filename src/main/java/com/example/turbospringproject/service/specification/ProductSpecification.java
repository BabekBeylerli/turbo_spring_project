package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
@AllArgsConstructor
public class ProductSpecification implements Specification<ProductEntity> {
    private String type;
    private String banType;


    @Override
    public Specification<ProductEntity> and(Specification<ProductEntity> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<ProductEntity> or(Specification<ProductEntity> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
