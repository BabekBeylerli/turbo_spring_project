package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.CarSalonEntity;
import com.example.turbospringproject.dao.entity.CityEntity;
import com.example.turbospringproject.dao.entity.ModelEntity;
import com.example.turbospringproject.dao.entity.UserEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate updateAt;
    private LocalDate createdAt;
    private CityEntity city;
    private CarSalonEntity car;
    private UserEntity user;
    private ModelEntity model;


}
