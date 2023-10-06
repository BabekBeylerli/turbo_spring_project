package com.example.turbospringproject.dao.entity;

import com.example.turbospringproject.dao.entity.enums.EMarch;
import com.example.turbospringproject.dao.entity.enums.EProduct;
import com.example.turbospringproject.dao.entity.enums.PriceType;
import com.example.turbospringproject.dao.entity.enums.ProductActiveStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;
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
    @JoinColumn(name = "e_product")
    private EProduct eProduct=EProduct.SIMPLE;
    private String banType;
    private Double march;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EMarch marchType=EMarch.km;
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
    private Integer viewCount=0;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ProductActiveStatus productActiveStatus=ProductActiveStatus.PENDING;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "id")
    private ModelEntity model;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "id")
    private CityEntity city;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "id")
    private CarSalonEntity car;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "id")
    private SubModelEntity subModel;

    @OneToOne(cascade = CascadeType.PERSIST)
    private CarSituationEntity carSituations;

    @OneToOne(cascade = CascadeType.PERSIST)
    private SupplyEntity supply;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PictureEntity> pictures;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "id")
    private BrandEntity brand;



}