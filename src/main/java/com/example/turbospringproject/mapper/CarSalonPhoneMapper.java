package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.CarSalonPhoneEntity;
import com.example.turbospringproject.model.CarSalonPhoneDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class CarSalonPhoneMapper {
    public static CarSalonPhoneMapper mapper = Mappers.getMapper(CarSalonPhoneMapper.class);

    public abstract CarSalonPhoneDto mapEntityToDto(CarSalonPhoneEntity carSalonPhoneEntity);

    public abstract CarSalonPhoneEntity mapDtoToEntity(CarSalonPhoneDto carSalonPhoneDto);
    public abstract CarSalonPhoneEntity mapDtoToEntity(CarSalonPhoneDto carSalonPhoneDto,Integer carSalonPhoneId);

    public abstract List<CarSalonPhoneDto> mapEntityToDtos(List<CarSalonPhoneEntity> carSalonPhoneEntities);

}
