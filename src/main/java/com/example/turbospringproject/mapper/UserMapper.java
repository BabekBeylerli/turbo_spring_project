package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.UserEntity;
import com.example.turbospringproject.model.UserDto;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class UserMapper {
    public static UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public abstract UserDto mapEntityToDto(UserEntity userEntity);

    public abstract UserEntity mapDtoToEntity(UserDto userDto);

    public abstract UserEntity mapDtoToEntity(UserDto userDto, Integer userId);

    public abstract List<UserDto> mapEntityToDtos(List<UserEntity> userEntities);
}
