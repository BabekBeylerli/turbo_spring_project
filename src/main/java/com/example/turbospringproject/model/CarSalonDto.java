package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.CarSalonPhoneEntity;
import com.example.turbospringproject.dao.entity.ProductEntity;
import com.example.turbospringproject.dao.entity.enums.ECarSalon;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarSalonDto {
    private String tittle;
    private ECarSalon type;
    private String description;
    private String description1;
    private String description2;
    private String logo;
    private String image;
    private Integer productsCount;
    private Integer viewNumber;
    private String location;
    private List<ProductLiteDto> product;
    private List<CarSalonPhoneDto> phones;
}
