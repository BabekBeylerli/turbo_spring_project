package com.example.turbospringproject.service.specification;

import com.example.turbospringproject.dao.entity.*;
import com.example.turbospringproject.dao.entity.enums.ProductOwnerType;
import com.example.turbospringproject.model.ProductFilterDto;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<ProductEntity> {
    private final ProductFilterDto productFilterDto;

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
        if (productFilterDto.getProductOwnerType() != null) {
            Join<ProductEntity, CarSalonEntity> carSalonJoin = root.join("car", JoinType.INNER);
            Join<ProductEntity, UserEntity> userJoin = root.join("user", JoinType.INNER);

            if (productFilterDto.getProductOwnerType() == ProductOwnerType.USER) {
                predicates.add(criteriaBuilder.isNotNull(userJoin.get("id")));
            } else if (productFilterDto.getProductOwnerType() == ProductOwnerType.CAR_SALON) {
                predicates.add(criteriaBuilder.isNotNull(carSalonJoin.get("id")));
            }
        }

        // SubModelEntity'ye filtre eklemek için
        if (productFilterDto.getSubModelName() != null) {
            Join<ProductEntity, ModelEntity> modelJoin = root.join("model", JoinType.INNER);
            Join<ModelEntity, SubModelEntity> subModelJoin = modelJoin.join("subModel", JoinType.INNER);
            predicates.add(criteriaBuilder.equal(subModelJoin.get("name"), productFilterDto.getSubModelName()));
        }

        // BrandEntity'ye filtre eklemek için
        if (productFilterDto.getBrandName() != null) {
            Join<ProductEntity, ModelEntity> modelJoin = root.join("model", JoinType.INNER);
            Join<ModelEntity, BrandEntity> brandJoin = modelJoin.join("brand", JoinType.INNER);
            predicates.add(criteriaBuilder.equal(brandJoin.get("name"), productFilterDto.getBrandName()));
        }

        // CityEntity'ye filtre eklemek için
        if (productFilterDto.getCityName() != null) {
            Join<ProductEntity, CityEntity> cityJoin = root.join("city", JoinType.INNER);
            predicates.add(criteriaBuilder.equal(cityJoin.get("name"), productFilterDto.getCityName()));
        }

        // ModelEntity'ye filtre eklemek için
        if (productFilterDto.getModelName() != null) {
            Join<ProductEntity, ModelEntity> modelJoin = root.join("model", JoinType.INNER);
        }
        // CarSituationEntity'ye filtre eklemek için
        Join<ProductEntity, CarSituationEntity> carSituationJoin = root.join("carSituations", JoinType.INNER);
        if (productFilterDto.isStroke()) {
            predicates.add(criteriaBuilder.isTrue(carSituationJoin.get("stroke")));
        }
        if (productFilterDto.isColored()) {
            predicates.add(criteriaBuilder.isTrue(carSituationJoin.get("colored")));
        }
        if (productFilterDto.isAccident()) {
            predicates.add(criteriaBuilder.isTrue(carSituationJoin.get("accident")));
        }
        if (productFilterDto.isCredit()) {
            predicates.add(criteriaBuilder.isTrue(carSituationJoin.get("credit")));
        }
        if (productFilterDto.isBarter()) {
            predicates.add(criteriaBuilder.isTrue(carSituationJoin.get("barter")));
        }
        // SupplyEntity'ye filtre eklemek için
        Join<ProductEntity, SupplyEntity> supplyJoin = root.join("supply", JoinType.INNER);
        if (productFilterDto.isAlloyWheels()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("alloyWheels")));
        }
        if (productFilterDto.isAbs()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("abs")));
        }
        if (productFilterDto.isHatch()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("hatch")));
        }
        if (productFilterDto.isRainSensor()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("rainSensor")));
        }
        if (productFilterDto.isCentralLocking()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("centralLocking")));
        }
        if (productFilterDto.isParkingRadar()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("parkingRadar")));
        }
        if (productFilterDto.isAirConditioning()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("airConditioning")));
        }
        if (productFilterDto.isSeatHeating()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("seatHeating")));
        }
        if (productFilterDto.isLeatherSalon()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("leatherSalon")));
        }
        if (productFilterDto.isXenonLamps()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("xenonLamps")));
        }
        if (productFilterDto.isRearViewCamera()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("rearViewCamera")));
        }
        if (productFilterDto.isSideCurtains()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("sideCurtains")));
        }
        if (productFilterDto.isSeatVentilation()) {
            predicates.add(criteriaBuilder.isTrue(supplyJoin.get("seatVentilation")));
        }

        // Combine predicates with AND
        if (!predicates.isEmpty()) {
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }

        return null;
    }

}