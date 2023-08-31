package com.example.turbospringproject.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.repository.cdi.Eager;

import java.time.LocalDateTime;

@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String banType;
    private double march;
    private String marchType;
    private String color;
    private double price;
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
    private Integer carSalonId;
    private Integer userId;
    private Integer modelId;
    private Integer cityId;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private CityEntity city;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private CarSalonEntity car;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private ModelEntity model;


}