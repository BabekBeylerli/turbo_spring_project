package com.example.turbospringproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ModelsMapper {
public static ModelsMapper mapper= Mappers.getMapper(ModelsMapper.class);
}
