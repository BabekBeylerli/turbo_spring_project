package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.RoleEntity;
import com.example.turbospringproject.model.auth.RoleDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private String phoneNumber;
    @Min(value=0)
    private Double balance;
    @Email(message = "Email should be valid.")
    private String email;
}
