package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.*;
import com.example.turbospringproject.dao.entity.enums.EMarch;
import com.example.turbospringproject.dao.entity.enums.EProduct;
import com.example.turbospringproject.dao.entity.enums.PriceType;
import com.example.turbospringproject.dao.entity.enums.ProductActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {
    private EProduct eProduct;
    private String banType;
    private Double march;
    private EMarch marchType;
    private String color;
    private Double price;
    private PriceType priceType;
    private Integer owners;
    private String fuelType;
    private String gear;
    private String gearBox;
    private Integer year;
    private Double engineVolume;
    private Integer enginePower;
    private String market;
    private Integer seatsNumber;
    private String vinCode;
    private String description;
    private Integer viewCount;
    private ProductActiveStatus activeStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private Integer cityId;
    private Integer brandId;
    private Integer modelId;
    private Integer subModelId;
    private Integer carSalonId;
    private Integer userId;
    private CarSituationDto carSituations;
    private SupplyDto supply;
    private List<PictureDto> pictures;
}
