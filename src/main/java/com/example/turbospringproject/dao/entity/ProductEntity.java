package com.example.turbospringproject.dao.entity;

import com.example.turbospringproject.dao.entity.enums.EProduct;
import com.example.turbospringproject.dao.entity.enums.PriceType;
import com.example.turbospringproject.dao.entity.enums.ProductActiveStatus;
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
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EProduct eProduct=EProduct.SIMPLE;
    private String banType;
    private Double march;
    private String marchType;
    private String color;
    private Double price;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private PriceType priceType=PriceType.AZN;
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
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ProductActiveStatus productActiveStatus=ProductActiveStatus.PENDING;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ModelEntity model;

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
    private SubModelEntity subModel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private CarSituationEntity carSituations;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private SupplyEntity supply;

    @OneToMany
    private List<PictureEntity> pictures;



}