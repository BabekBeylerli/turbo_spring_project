package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.SupplyEntity;
import com.example.turbospringproject.model.SupplyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class SupplyMapper {
    public static SupplyMapper mapper = Mappers.getMapper(SupplyMapper.class);

    public abstract SupplyDto mapEntityToDto(SupplyEntity supplyEntity);

    public abstract SupplyEntity mapDtoToEntity(SupplyDto supplyDto);

    public abstract SupplyEntity mapDtoToEntity(SupplyDto supplyDto, Integer supplyId);

    public abstract List<SupplyDto> mapEntityToDtos(List<SupplyEntity> supplyEntities);
}
