package com.example.turbospringproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CarSalonsMapper {
public static CarSalonsMapper mapper= Mappers.getMapper(CarSalonsMapper.class);
}
