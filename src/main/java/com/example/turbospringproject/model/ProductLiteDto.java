package com.example.turbospringproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductLiteDto {
    private Double price;
    private String priceType;
    private Integer year;
    private Double engineVolume;
    private Double march;
    private String marchType;
    private LocalDateTime createdAt;
    private String brandName;
    private String modelName;
    private String subModelName;
    private String cityName;
    private String picture;
}
