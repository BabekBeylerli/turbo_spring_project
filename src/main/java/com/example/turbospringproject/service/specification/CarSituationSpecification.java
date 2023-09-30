package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.model.CarSituationDto;
import com.example.turbospringproject.model.CarSituationFilterDto;
import org.springframework.data.jpa.domain.Specification;

public class CarSituationSpecification {
    public static Specification<CarSituationDto> filterByStroke(boolean stroke) {
        return (root, query, criteriaBuilder) ->
                stroke ? criteriaBuilder.isTrue(root.get("stroke")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
        public static Specification<CarSituationDto> filterByColored(boolean colored) {
        return (root, query, criteriaBuilder) ->
                colored ? criteriaBuilder.isTrue(root.get("colored")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
    public static Specification<CarSituationFilterDto> filterByAccident(boolean accident) {
        return (root, query, criteriaBuilder) ->
                accident ? criteriaBuilder.isTrue(root.get("accident")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
    public static Specification<CarSituationFilterDto> filterByCredit(boolean credit) {
        return (root, query, criteriaBuilder) ->
                credit ? criteriaBuilder.isTrue(root.get("credit")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
        public static Specification<CarSituationFilterDto> filterByBarter(boolean barter) {
        return (root, query, criteriaBuilder) ->
                barter ? criteriaBuilder.isTrue(root.get("barter")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
}
