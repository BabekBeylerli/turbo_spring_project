package com.example.turbospringproject.dao.entity;

import com.example.turbospringproject.dao.entity.enums.ECarSalon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "car_salons")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarSalonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tittle;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ECarSalon type = ECarSalon.SIMPLE;
    private String email;
    private String password;
    private String description;
    private String description1;
    private String description2;
    private String logo;
    private String image;
    private Integer productsCount;
    private Integer viewNumber;
    private String location;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @OneToMany(mappedBy = "car")
    private List<ProductEntity> product;
    @OneToMany(mappedBy = "carSalon",
            cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<CarSalonPhoneEntity> phones;

}
