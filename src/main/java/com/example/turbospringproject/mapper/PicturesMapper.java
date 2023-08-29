package com.example.turbospringproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class PicturesMapper {
public static PicturesMapper mapper= Mappers.getMapper(PicturesMapper.class);
}
