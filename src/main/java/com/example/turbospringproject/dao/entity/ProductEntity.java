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
import java.util.List;

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
    private Double engineVolume;
    private Integer enginePower;
    private String market;
    private Integer seatsNumber;
    private String vinCode;
    private String description;
    private Integer viewCount;
    private String activeStatus;
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
    private SubModelEntity model;
    @OneToMany(mappedBy = "product")
    private List<CarSituationEntity> carSituations;
    @OneToOne(mappedBy = "product")
    private SupplyEntity supply;
    @OneToMany(mappedBy = "product")
    private List<PictureEntity> pictures;


}