package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.ModelEntity;
import com.example.turbospringproject.model.ModelDto;
import com.example.turbospringproject.model.ModelLiteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class ModelMapper {
    public static ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
    public abstract ModelDto mapEntityToDto(ModelEntity modelEntity);
    @Mapping(target="name",source = "name")
    @Mapping(target="brand.id",source = "brandId")
    public abstract ModelEntity mapDtoToEntity(ModelLiteDto modelDto);

    public abstract List<ModelDto> mapEntityToDtos(List<ModelEntity> modelEntities);

}
