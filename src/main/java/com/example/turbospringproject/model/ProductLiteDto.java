package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.enums.PriceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductLiteDto {
    private Double price;
    private PriceType priceType;
    private Integer year;
    private Double engineVolume;
    private Double march;
    private String marchType;
    private LocalDateTime createdAt;
    private String brandName;
    private String modelName;
    private String subModelName;
    private String cityName;
    private List<PictureDto> pictures;
}
