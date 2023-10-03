package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.RoleEntity;
import com.example.turbospringproject.model.auth.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class RoleMapper {
    public static RoleMapper mapper = Mappers.getMapper(RoleMapper.class);
    public abstract RoleEntity mapDtoToEntity(RoleDto roleDto);
    public abstract RoleDto mapEntityToDto(RoleEntity roleEntity);


}
