package com.example.turbospringproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterDto {
    private String color;
    private Double upPrice;
    private Double downPrice;
    private String priceType;
    private String fuelType;
    private String gear;
    private String gearBox;
    private Double upEngineVolume;
    private Double downEngineVolume;
    private Integer upEnginePower;
    private Integer downEnginePower;
    private Integer owners;
    private Integer upYear;
    private Integer downYear;
    private String market;
    private Integer seatsNumber;

}