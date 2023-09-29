package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.model.ProductFilterDto;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<ProductEntity> {
    private final ProductFiltedrDto productFilterDto;

    public ProductSpecification(final ProductFilterDto productFilterDto) {
        this.productFilterDto = productFilterDto;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (productFilterDto.getColor() != null) {
            predicates.add(criteriaBuilder.equal(root.get("color"), productFilterDto.getColor()));
        }

        if (productFilterDto.getUpPrice() != null) {
            predicates.add(criteriaBuilder.equal(root.get("upPrice"), productFilterDto.getUpPrice()));
        }
        if (productFilterDto.getDownPrice() != null) {
            predicates.add(criteriaBuilder.equal(root.get("downPrice"), productFilterDto.getDownPrice()));
        }
        if (productFilterDto.getPriceType() != null) {
            predicates.add(criteriaBuilder.equal(root.get("priceType"), productFilterDto.getPriceType()));
        }

        // Combine predicates with AND
        if (!predicates.isEmpty()) {
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }

        return null;
    }
}

