package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.CarSalonEntity;
import com.example.turbospringproject.model.CarSalonDto;
import com.example.turbospringproject.model.CarSalonLiteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class CarSalonMapper {
    public static CarSalonMapper mapper = Mappers.getMapper(CarSalonMapper.class);

    public abstract CarSalonDto mapEntityToDto(CarSalonEntity carSalonEntity);

    public abstract CarSalonEntity mapDtoToEntity(CarSalonDto carSalonDto);

    public abstract CarSalonEntity mapDtoToEntity(CarSalonDto carSalonDto, Integer carSalonId);

    public abstract List<CarSalonDto> mapEntityToDtos(List<CarSalonEntity> carSalonEntities);
    public abstract CarSalonLiteDto mapEntityToDto2(CarSalonEntity carSalonEntity);
    public abstract List<CarSalonLiteDto> mapEntityToDtos2(List<CarSalonEntity> carSalonEntities);
}
