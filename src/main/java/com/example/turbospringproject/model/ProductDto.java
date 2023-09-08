package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {
    private String type;
    private String banType;
    private Double march;
    private String marchType;
    private String color;
    private Double price;
    private String priceType;
    private Integer owners;
    private String fuelType;
    private String gear;
    private String gearBox;
    private Integer year;
    private Integer engineVolume;
    private Integer enginePower;
    private String market;
    private Integer seatsNumber;
    private String vinCode;
    private String description;
    private Integer viewCount;
    private String activeStatus;
    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    private CityEntity city;

    private CarSalonEntity car;

    private UserEntity user;

    private SubModelEntity model;
    private List<CarSituationEntity> carSituations;
    private SupplyEntity supply;
    private List<PictureEntity> pictures;


}
