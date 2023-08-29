package com.example.turbospringproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProductsMapper {
public static ProductsMapper mapper= Mappers.getMapper(ProductsMapper.class);
}
