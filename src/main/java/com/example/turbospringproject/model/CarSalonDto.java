package com.example.turbospringproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
