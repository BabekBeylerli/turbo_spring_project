package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.BrandEntity;
import com.example.turbospringproject.model.BrandDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class BrandMapper {
    public static BrandMapper mapper = Mappers.getMapper(BrandMapper.class);

    public abstract BrandDto mapEntityToDto(BrandEntity brandEntity);

    public abstract BrandEntity mapDtoToEntity(BrandDto brandDto);
}
