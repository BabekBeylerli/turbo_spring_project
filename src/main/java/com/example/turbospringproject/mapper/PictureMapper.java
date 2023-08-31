package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.PictureEntity;
import com.example.turbospringproject.model.PictureDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class PictureMapper {
    public static PictureMapper mapper = Mappers.getMapper(PictureMapper.class);

    public abstract PictureDto mapEntityToDto(PictureEntity pictureEntity);

    public abstract PictureEntity mapDtoToEntity(PictureDto pictureDto);

    public abstract PictureEntity mapDtoToEntity(PictureDto pictureDto, Integer pictureId);

    public abstract List<PictureDto> mapEntityToDtos(List<PictureEntity> pictureEntities);
}
