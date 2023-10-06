package com.example.turbospringproject.model.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDto {
    @Column(name = "phone_number", length = 10)
    private String phoneNumber;
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-_+=])(?=\\S+$).{8,}$",
            message = "Password must have at least 1 uppercase letter, 1 special character, and a minimum length of 8 characters."
    )
    @Size(min = 8, message = "Password must have a minimum length of 8 characters.")
    private String password;
}
