package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.CarSituationEntity;
import com.example.turbospringproject.dao.entity.PictureEntity;
import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.model.PictureDto;
import com.example.turbospringproject.model.ProductDto;
import com.example.turbospringproject.model.ProductLiteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class ProductMapper {
    public static ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
    @Mapping(target = "cityId", source = "city.id")
    @Mapping(target = "brandId", source = "brand.id")
    @Mapping(target = "modelId", source = "model.id")
    @Mapping(target = "subModelId", source = "subModel.id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "carSalonId", source = "car.id")
    public abstract ProductDto mapEntityToDto(ProductEntity productEntity);

    @Mapping(target = "city.id", source = "cityId")
    @Mapping(target = "brand.id", source = "brandId")
    @Mapping(target = "model.id", source = "modelId")
    @Mapping(target = "subModel.id", source = "subModelId")
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "car.id", source = "carSalonId")
    public abstract ProductEntity mapDtoToEntity(ProductDto productDto);

    public abstract ProductEntity mapDtoToEntity(ProductDto productDto,Integer productId);

    public abstract List<ProductDto> mapEntityToDtos(List<ProductEntity> productEntities);
    @Mapping(target="price",source = "price")
    @Mapping(target="priceType",source = "priceType")
    @Mapping(target="year",source="year")
    @Mapping(target="engineVolume",source="engineVolume")
    @Mapping(target="march",source="march")
    @Mapping(target="marchType",source="marchType")
    @Mapping(target="createdAt",source="createdAt")
    @Mapping(target="eProduct",source="EProduct")
    @Mapping(target="brandName",source="brand.name")
    @Mapping(target="modelName",source = "model.name")
    @Mapping(target="subModelName",source="subModel.name")
    @Mapping(target="cityName",source="city.name")
    @Mapping(target="barter",source="carSituations.barter")
    @Mapping(target="credit",source="carSituations.credit")
    @Mapping(target="carSalonId",source="car.id")
    public abstract ProductLiteDto mapEntityToLiteDto(ProductEntity productEntity);
    @Mapping(target="price",source = "price")
    @Mapping(target="priceType",source = "priceType")
    @Mapping(target="year",source="year")
    @Mapping(target="engineVolume",source="engineVolume")
    @Mapping(target="march",source="march")
    @Mapping(target="marchType",source="marchType")
    @Mapping(target="createdAt",source="createdAt")
    @Mapping(target="brandName",source="brand.name")
    @Mapping(target="modelName",source = "model.name")
    @Mapping(target="subModelName",source="subModel.name")
    @Mapping(target="cityName",source="city.name")
    @Mapping(target="barter",source="carSituations.barter")
    @Mapping(target="credit",source="carSituations.credit")
    @Mapping(target="carSalonId",source="car.id")
    @Mapping(target="eProduct",source="EProduct")
    public abstract List<ProductLiteDto> mapEntityToLiteDtos2(List<ProductEntity> productEntities);




}
