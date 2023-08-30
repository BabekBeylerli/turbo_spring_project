package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.SubModelEntity;
import com.example.turbospringproject.model.SubModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class SubModelMapper {
    public static SubModelMapper mapper = Mappers.getMapper(SubModelMapper.class);

    public abstract SubModelDto mapEntityToDto(SubModelEntity subModelEntity);

    public abstract SubModelEntity mapDtoToEntity(SubModelDto subModelDto);
}
