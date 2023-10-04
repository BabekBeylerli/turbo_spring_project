package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.SubModelEntity;
import com.example.turbospringproject.model.SubModelDto;
import com.example.turbospringproject.model.SubModelLiteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class SubModelMapper {
    public static SubModelMapper mapper = Mappers.getMapper(SubModelMapper.class);
    @Mapping(target="name",source="name")
    @Mapping(target="model.id",source="modelId")
    public abstract SubModelEntity mapLiteDtoToEntity(SubModelLiteDto subModelLiteDto);

    public abstract SubModelDto mapEntityToDto(SubModelEntity subModelEntity);

    public abstract SubModelEntity mapDtoToEntity(SubModelDto subModelDto);

    public abstract List<SubModelDto> mapEntityToDtos(List<SubModelEntity> subModelEntities);
}
