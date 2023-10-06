package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.enums.EMarch;
import com.example.turbospringproject.dao.entity.enums.EProduct;
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
    private Integer id;
    private Double price;
    private PriceType priceType;
    private Integer year;
    private Double engineVolume;
    private Double march;
    private EMarch marchType;
    private LocalDateTime createdAt;
    private EProduct eProduct;
    private Integer carSalonId;
    private Boolean credit;
    private Boolean barter;
    private String brandName;
    private String modelName;
    private String subModelName;
    private String cityName;
    private List<PictureDto> pictures;
}
