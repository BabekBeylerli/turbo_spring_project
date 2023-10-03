package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.RoleEntity;
import com.example.turbospringproject.model.auth.RoleDto;
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
    private double balance;
    private Set<RoleDto> roles;
}
