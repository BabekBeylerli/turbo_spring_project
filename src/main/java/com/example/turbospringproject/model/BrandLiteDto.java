package com.example.turbospringproject.model;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandLiteDto {
    private Integer id;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Should contain only alphabetic characters.")
    private String name;
}
