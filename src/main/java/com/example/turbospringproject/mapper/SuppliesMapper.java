package com.example.turbospringproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class SuppliesMapper {
public static SuppliesMapper mapper= Mappers.getMapper(SuppliesMapper.class);
}
