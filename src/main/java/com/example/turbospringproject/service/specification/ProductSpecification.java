package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.CarSalonEntity;
import com.example.turbospringproject.dao.entity.CityEntity;
import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.dao.entity.SubModelEntity;
import com.example.turbospringproject.dao.entity.enums.ProductActiveStatus;
import com.example.turbospringproject.dao.entity.enums.SearchOperation;
import com.example.turbospringproject.model.ProductFilterDto;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class ProductSpecification implements Specification<ProductEntity> {
    private final ProductFilterDto productFilterDto;

    public ProductSpecification(final ProductFilterDto productFilterDto) {
        super();
        this.productFilterDto = productFilterDto;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        String strSearch =
                productFilterDto.getValue()
                        .toString()
                        .toLowerCase();
        switch (Objects.requireNonNull(
                SearchOperation.getSimpleOperation(
                        productFilterDto.getOperation()))) {
            case CONTAINS:
                return criteriaBuilder.like(criteriaBuilder.lower(root.get(productFilterDto.getFilterKey())), "%" + strSearch + "%");
        }
        return null;
    }

//    private Join<ProductEntity, CityEntity> cityJoin(Root<ProductEntity> root) {
//        return root.join("city");
//    }
//
//    private Join<ProductEntity, CarSalonEntity> carSalonJoin(Root<ProductEntity> root) {
//        return root.join("car");
//    }
//    private Join<ProductEntity, SubModelEntity> subModelJoin(Root<ProductEntity> root){
//        return root.join("model");
//    }
}
