package com.example.turbospringproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CarSituationMapper {
public static CarSituationMapper mapper= Mappers.getMapper(CarSituationMapper.class);
}
