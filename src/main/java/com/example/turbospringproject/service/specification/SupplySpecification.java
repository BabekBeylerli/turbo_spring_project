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

    public static Specification<SupplyFilterDto> filterByLeatherSalon(boolean leatherSalon) {
        return ((root, query, criteriaBuilder) ->
                leatherSalon ? criteriaBuilder.isTrue(root.get("leatherSalon")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

    public static Specification<SupplyFilterDto> filterByXenonLamps(boolean xenonLamps) {
        return ((root, query, criteriaBuilder) ->
                xenonLamps ? criteriaBuilder.isTrue(root.get("xenonLamps")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

    public static Specification<SupplyFilterDto> filterByRearViewCamera(boolean rearViewCamera) {
        return ((root, query, criteriaBuilder) ->
                rearViewCamera ? criteriaBuilder.isTrue(root.get("rearViewCamera")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

    public static Specification<SupplyFilterDto> filterBySideCurtains(boolean sideCurtains) {
        return ((root, query, criteriaBuilder) ->
                sideCurtains ? criteriaBuilder.isTrue(root.get("sideCurtains")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }


    public static Specification<SupplyFilterDto> filterBySeatVentilation(boolean seatVentilation) {
        return ((root, query, criteriaBuilder) ->
                seatVentilation ? criteriaBuilder.isTrue(root.get("seatVentilation")) :
                        criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
    }

}

