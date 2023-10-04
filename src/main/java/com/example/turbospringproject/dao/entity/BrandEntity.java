package com.example.turbospringproject.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.Banner;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "brands")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @OneToMany(fetch = FetchType.EAGER
            ,mappedBy = "brand")
    private List<ModelEntity> model;
    @OneToMany(mappedBy = "brand"
              ,fetch=FetchType.EAGER)
    private List<ProductEntity> product;
}
