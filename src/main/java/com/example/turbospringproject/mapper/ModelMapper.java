package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.ModelEntity;
import com.example.turbospringproject.model.ModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ModelMapper {
    public static ModelMapper mapper = Mappers.getMapper(ModelMapper.class);

    public abstract ModelDto mapEntityToDto(ModelEntity modelEntity);

    public abstract ModelEntity mapDtoToEntity(ModelDto modelDto);
}
