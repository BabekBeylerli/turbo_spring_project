package com.example.turbospringproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSalonLiteDto {
    private String tittle;
    private String type;
    private String description;
    private String logo;
    private Integer productsCount;
    private List<CarSalonPhoneDto> phones;

}
