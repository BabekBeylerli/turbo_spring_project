package com.example.turbospringproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class BrandsMapper {
    public static BrandsMapper mapper= Mappers.getMapper(BrandsMapper.class);

}
