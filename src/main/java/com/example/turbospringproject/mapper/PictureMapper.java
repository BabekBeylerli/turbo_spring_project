package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.PictureEntity;
import com.example.turbospringproject.model.PictureDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class PictureMapper {
    public static PictureMapper mapper = Mappers.getMapper(PictureMapper.class);

    public abstract PictureDto mapEntityToDto(PictureEntity pictureEntity);

    public abstract PictureEntity mapDtoToEntity(PictureDto pictureDto);
}
