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

        if (productFilterDto.getUpPrice() != null && productFilterDto.getDownPrice() != null) {
            predicates.add(criteriaBuilder.between(root.get("price"), productFilterDto.getDownPrice(), productFilterDto.getUpPrice()));
        }
        if (productFilterDto.getPriceType() != null) {
            predicates.add(criteriaBuilder.equal(root.get("priceType"), productFilterDto.getPriceType()));
        }
        if (productFilterDto.getFuelType() != null) {
            predicates.add(criteriaBuilder.equal(root.get("fuelType"), productFilterDto.getFuelType()));
        }
        if (productFilterDto.getGear() != null) {
            predicates.add(criteriaBuilder.equal(root.get("gear"), productFilterDto.getGear()));
        }
        if (productFilterDto.getGearBox() != null) {
            predicates.add(criteriaBuilder.equal(root.get("gearBox"), productFilterDto.getGearBox()));
        }
        if (productFilterDto.getUpEngineVolume() != null && productFilterDto.getDownEngineVolume() != null) {
            predicates.add(criteriaBuilder.between(root.get("engineVolume"), productFilterDto.getDownEngineVolume(), productFilterDto.getUpEngineVolume()));
        }
        if (productFilterDto.getUpEnginePower() != null && productFilterDto.getDownEnginePower() != null) {
            predicates.add(criteriaBuilder.between(root.get("enginePower"), productFilterDto.getDownEnginePower(), productFilterDto.getUpEnginePower()));
        }
        if (productFilterDto.getOwners() != null) {
            predicates.add(criteriaBuilder.equal(root.get("owners"), productFilterDto.getOwners()));
        }
        if (productFilterDto.getUpYear() != null && productFilterDto.getDownYear() != null) {
            predicates.add(criteriaBuilder.between(root.get("year"), productFilterDto.getDownYear(), productFilterDto.getUpYear()));
        }
        if (productFilterDto.getMarket() != null) {
            predicates.add(criteriaBuilder.equal(root.get("market"), productFilterDto.getMarket()));
        }
        if (productFilterDto.getSeatsNumber() != null) {
            predicates.add(criteriaBuilder.equal(root.get("seatsNumber"), productFilterDto.getSeatsNumber()));
        }

        // Combine predicates with AND
        if (!predicates.isEmpty()) {
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }

        return null;
    }
}

