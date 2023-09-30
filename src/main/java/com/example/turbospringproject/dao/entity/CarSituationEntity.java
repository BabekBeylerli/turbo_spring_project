package com.example.turbospringproject.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "car_situation")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarSituationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean stroke;
    private boolean colored;
    private boolean accident;
    private boolean credit;
    private boolean barter;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @OneToMany(mappedBy = "carSituations")
    private List<ProductEntity> product;

}