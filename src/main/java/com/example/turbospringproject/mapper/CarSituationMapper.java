package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.CarSituationEntity;
import com.example.turbospringproject.model.CarSituationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class CarSituationMapper {
    public static CarSituationMapper mapper = Mappers.getMapper(CarSituationMapper.class);

    public abstract CarSituationDto mapEntityToDto(CarSituationEntity carSituationEntity);

    public abstract CarSituationEntity mapDtoToEntity(CarSituationDto carSituationDto);

    public abstract List<CarSituationDto> mapEntityToDtos(List<CarSituationEntity> carSituationEntities);
}
