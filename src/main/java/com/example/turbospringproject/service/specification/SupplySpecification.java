package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.SupplyEntity;
import com.example.turbospringproject.model.SupplyFilterDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SupplySpecification implements Specification<SupplyEntity> {

    private final SupplyFilterDto supplyFilterDto;

    public SupplySpecification(final SupplyFilterDto supplyFilterDto) {
        this.supplyFilterDto = supplyFilterDto;
    }

    @Override
    public Predicate toPredicate(Root<SupplyEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (supplyFilterDto.isAlloyWheels()) {
            predicates.add(criteriaBuilder.isTrue(root.get("alloyWheels")));
        }

        if (supplyFilterDto.isAbs()) {
            predicates.add(criteriaBuilder.isTrue(root.get("abs")));
        }

        if (supplyFilterDto.isHatch()) {
            predicates.add(criteriaBuilder.isTrue(root.get("hatch")));
        }

        if (supplyFilterDto.isRainSensor()) {
            predicates.add(criteriaBuilder.isTrue(root.get("rainSensor")));
        }

        if (supplyFilterDto.isCentralLocking()) {
            predicates.add(criteriaBuilder.isTrue(root.get("centralLocking")));
        }

        if (supplyFilterDto.isParkingRadar()) {
            predicates.add(criteriaBuilder.isTrue(root.get("parkingRadar")));
        }

        if (supplyFilterDto.isAirConditioning()) {
            predicates.add(criteriaBuilder.isTrue(root.get("airConditioning")));
        }

        if (supplyFilterDto.isSeatHeating()) {
            predicates.add(criteriaBuilder.isTrue(root.get("seatHeating")));
        }

        if (supplyFilterDto.isLeatherSalon()) {
            predicates.add(criteriaBuilder.isTrue(root.get("leatherSalon")));
        }

        if (supplyFilterDto.isXenonLamps()) {
            predicates.add(criteriaBuilder.isTrue(root.get("xenonLamps")));
        }

        if (supplyFilterDto.isRearViewCamera()) {
            predicates.add(criteriaBuilder.isTrue(root.get("rearViewCamera")));
        }

        if (supplyFilterDto.isSideCurtains()) {
            predicates.add(criteriaBuilder.isTrue(root.get("sideCurtains")));
        }

        if (supplyFilterDto.isSeatVentilation()) {
            predicates.add(criteriaBuilder.isTrue(root.get("seatVentilation")));
        }

        if (!predicates.isEmpty()) {
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }

        return null;
    }
}
