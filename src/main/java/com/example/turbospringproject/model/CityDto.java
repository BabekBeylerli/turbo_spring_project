package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.ProductEntity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CityDto {
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Should contain only alphabetic characters.")
    private String name;
}
