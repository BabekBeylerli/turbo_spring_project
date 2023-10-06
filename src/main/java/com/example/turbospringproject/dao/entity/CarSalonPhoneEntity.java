package com.example.turbospringproject.dao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "car_salons_phones")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarSalonPhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name="car_salon_id",referencedColumnName = "id")
    private CarSalonEntity carSalon;

}
