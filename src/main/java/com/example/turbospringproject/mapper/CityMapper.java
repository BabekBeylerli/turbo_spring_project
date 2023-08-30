package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.CityEntity;
import com.example.turbospringproject.model.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CityMapper {
    public static CityMapper mapper = Mappers.getMapper(CityMapper.class);

    public abstract CityDto mapEntityToDto(CityEntity cityEntity);

    public abstract CityEntity mapDtoToEntity(CityDto cityDto);
}
