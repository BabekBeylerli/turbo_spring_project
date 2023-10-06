package com.example.turbospringproject.model.auth;

import com.example.turbospringproject.dao.entity.RoleEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequestDto {
    @Column(name = "phone_number", length = 10)
    private String phoneNumber;
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-_+=])(?=\\S+$).{8,}$",
            message = "Password must have at least 1 uppercase letter, 1 special character, and a minimum length of 8 characters."
    )
    @Size(min = 8, message = "Password must have a minimum length of 8 characters.")
    private String password;
    private Set<RoleDto> roles;

}

