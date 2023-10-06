package com.example.turbospringproject.dao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "pictures")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PictureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private Integer sort;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne()
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;
}
