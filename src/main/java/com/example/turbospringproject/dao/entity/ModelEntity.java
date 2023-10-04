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

@Table(name = "models")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @OneToMany(mappedBy = "model",
              fetch=FetchType.EAGER)
    private List<ProductEntity> product;
    @OneToMany(mappedBy = "model"
            ,fetch = FetchType.EAGER)
    private List<SubModelEntity> subModel;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private BrandEntity brand;
}