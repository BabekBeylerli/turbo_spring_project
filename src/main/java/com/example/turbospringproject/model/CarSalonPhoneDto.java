package com.example.turbospringproject.model;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarSalonPhoneDto {
    @Pattern(regexp = "^[0-9+]*$", message = "Phone number can only contain digits and '+' sign.")
    @Size(min = 10, message = "Phone number must contain at least 10 characters.")
    private String number;
}
