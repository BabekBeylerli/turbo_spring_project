package com.example.turbospringproject.dao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "cities")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Should contain only alphabetic characters.")
    private String name;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "city")
    private List<ProductEntity> product;
}
