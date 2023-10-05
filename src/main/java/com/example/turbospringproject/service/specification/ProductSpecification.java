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

        if (productFilterDto.getUpPrice() != null && productFilterDto.getDownPrice() != null) {
            predicates.add(criteriaBuilder.between(root.get("price"), productFilterDto.getDownPrice(), productFilterDto.getUpPrice()));
        }
        if (productFilterDto.getPriceType() != null) {
            predicates.add(criteriaBuilder.equal(root.get("priceType"), productFilterDto.getPriceType()));
        }
        if (productFilterDto.getUpEngineVolume() != null && productFilterDto.getDownEngineVolume() != null) {
            predicates.add(criteriaBuilder.between(root.get("engineVolume"), productFilterDto.getDownEngineVolume(), productFilterDto.getUpEngineVolume()));
        }
        if (productFilterDto.getUpEnginePower() != null && productFilterDto.getDownEnginePower() != null) {
            predicates.add(criteriaBuilder.between(root.get("enginePower"), productFilterDto.getDownEnginePower(), productFilterDto.getUpEnginePower()));
        }
        if (productFilterDto.getUpYear() != null && productFilterDto.getDownYear() != null) {
            predicates.add(criteriaBuilder.between(root.get("year"), productFilterDto.getDownYear(), productFilterDto.getUpYear()));
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
        if (productFilterDto.getFuelType() != null && !productFilterDto.getFuelType().isEmpty()) {
            Expression<String> fuelTypeExpression = root.get("fuelType");
            Predicate fuelTypePredicate = fuelTypeExpression.in(productFilterDto.getFuelType());
            predicates.add(fuelTypePredicate);
        }

        if (productFilterDto.getGear() != null && !productFilterDto.getGear().isEmpty()) {
            Expression<String> gearExpression = root.get("gear");
            Predicate gearPredicate = gearExpression.in(productFilterDto.getGear());
            predicates.add(gearPredicate);
        }

        if (productFilterDto.getGearBox() != null && !productFilterDto.getGearBox().isEmpty()) {
            Expression<String> gearBoxExpression = root.get("gearBox");
            Predicate gearBoxPredicate = gearBoxExpression.in(productFilterDto.getGearBox());
            predicates.add(gearBoxPredicate);
        }

        if (productFilterDto.getOwners() != null) {
            Expression<Integer> ownersExpression = root.get("owners");
            Predicate ownersPredicate = ownersExpression.in(productFilterDto.getOwners());
            predicates.add(ownersPredicate);
        }

        if (productFilterDto.getSeatsNumber() != null) {
            Expression<Integer> seatNumberExpression = root.get("seatsNumber");
            Predicate seatNumberPredicate = seatNumberExpression.in(productFilterDto.getSeatsNumber());
            predicates.add(seatNumberPredicate);
        }

        if (productFilterDto.getMarket() != null && !productFilterDto.getMarket().isEmpty()) {
            Expression<String> marketExpression = root.get("market");
            Predicate marketPredicate = marketExpression.in(productFilterDto.getMarket());
            predicates.add(marketPredicate);
        }
        if (productFilterDto.getBanType() != null && !productFilterDto.getBanType().isEmpty()) {
            Expression<String> banTypeExpression = root.get("banType");
            Predicate banTypePredicate = banTypeExpression.in(productFilterDto.getBanType());
            predicates.add(banTypePredicate);
        }
        if (productFilterDto.getColor() != null && !productFilterDto.getColor().isEmpty()) {
            Expression<String> banTypeExpression = root.get("color");
            Predicate colorPredicate = banTypeExpression.in(productFilterDto.getColor());
            predicates.add(colorPredicate);
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