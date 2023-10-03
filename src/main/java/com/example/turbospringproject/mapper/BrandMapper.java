package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.BrandEntity;
import com.example.turbospringproject.model.BrandDto;
import com.example.turbospringproject.model.BrandLiteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class BrandMapper {
    public static BrandMapper mapper = Mappers.getMapper(BrandMapper.class);

    public abstract BrandDto mapEntityToDto(BrandEntity brandEntity);

    public abstract BrandEntity mapDtoToEntity(BrandDto brandDto);

    public abstract List<BrandDto> mapEntityToDtos(List<BrandEntity> brandEntities);
    public abstract BrandLiteDto mapEntityToDto2(BrandEntity brandEntity);

    public abstract List<BrandLiteDto> mapEntityToDtos2(List<BrandEntity> brandEntities);

    public abstract BrandEntity mapDtoToEntity(BrandDto brandDto, Integer brandId);
}
