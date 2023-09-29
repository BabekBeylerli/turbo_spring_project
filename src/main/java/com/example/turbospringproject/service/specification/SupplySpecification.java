package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.model.SupplyFilterDto;
import org.springframework.data.jpa.domain.Specification;


public class SupplySpecification {
    public static Specification<SupplyFilterDto> filterByAlloyWheels(boolean alloyWheels) {
        return (root, query, criteriaBuilder) ->
                alloyWheels ? criteriaBuilder.isTrue(root.get("alloyWheels")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }

    public static Specification<SupplyFilterDto> filterByUsa(boolean abs) {
        return ((root, query, criteriaBuilder) ->
                abs ? criteriaBuilder.isTrue(root.get("abs")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

    public static Specification<SupplyFilterDto> filterByHatch(boolean hatch) {
        return ((root, query, criteriaBuilder) ->
                hatch ? criteriaBuilder.isTrue(root.get("hatch")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

    public static Specification<SupplyFilterDto> filterByRainSensor(boolean rainSensor) {
        return ((root, query, criteriaBuilder) ->
                rainSensor ? criteriaBuilder.isTrue(root.get("rainSensor")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

    public static Specification<SupplyFilterDto> filterByCentralLocking(boolean centralLocking) {
        return ((root, query, criteriaBuilder) ->
                centralLocking ? criteriaBuilder.isTrue(root.get("centralLocking")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

    public static Specification<SupplyFilterDto> filterByParkingRadar(boolean parkingRadar) {
        return ((root, query, criteriaBuilder) ->
                parkingRadar ? criteriaBuilder.isTrue(root.get("parkingRadar")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

    public static Specification<SupplyFilterDto> filterByAirConditioning(boolean airConditioning) {
        return ((root, query, criteriaBuilder) ->
                airConditioning ? criteriaBuilder.isTrue(root.get("airConditioning")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

    public static Specification<SupplyFilterDto> filterBySeatHeating(boolean seatHeating) {
        return ((root, query, criteriaBuilder) ->
                seatHeating ? criteriaBuilder.isTrue(root.get("seatHeating")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }


}

