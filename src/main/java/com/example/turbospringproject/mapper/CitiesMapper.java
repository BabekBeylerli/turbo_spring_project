package com.example.turbospringproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CitiesMapper {
public static CitiesMapper mapper= Mappers.getMapper(CitiesMapper.class);
}
