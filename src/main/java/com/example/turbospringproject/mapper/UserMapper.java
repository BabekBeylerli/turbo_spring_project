package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.UserEntity;
import com.example.turbospringproject.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {
    public static UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public abstract UserDto mapEntityToDto(UserEntity userEntity);

    public abstract UserEntity mapDtoToEntity(UserDto userDto);
}
