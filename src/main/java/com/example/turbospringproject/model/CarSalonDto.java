package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.CarSalonPhoneEntity;
import com.example.turbospringproject.dao.entity.ProductEntity;
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
    private String type;
    private String description;
    private String description1;
    private String description2;
    private String logo;
    private String image;
    private Integer productsCount;
    private Integer viewNumber;
    private String location;
    private List<ProductEntity> product;
    private List<CarSalonPhoneEntity> phones;
}
