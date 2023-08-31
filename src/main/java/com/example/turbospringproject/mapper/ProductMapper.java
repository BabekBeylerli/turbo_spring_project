package com.example.turbospringproject.mapper;

import com.example.turbospringproject.dao.entity.PictureEntity;
import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.model.PictureDto;
import com.example.turbospringproject.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class ProductMapper {
    public static ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    public abstract ProductDto mapEntityToDto(ProductEntity productEntity);

    public abstract ProductEntity mapDtoToEntity(ProductDto productDto);

    public abstract ProductEntity mapDtoToEntity(ProductDto productDto,Integer productId);

    public abstract List<ProductDto> mapEntityToDtos(List<ProductEntity> productEntities);
}
