package com.example.turbospringproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class PrivateUsersMapper {
public static PrivateUsersMapper mapper= Mappers.getMapper(PrivateUsersMapper.class);
}
