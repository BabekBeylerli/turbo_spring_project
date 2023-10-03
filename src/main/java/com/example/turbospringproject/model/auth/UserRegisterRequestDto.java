package com.example.turbospringproject.model.auth;

import com.example.turbospringproject.dao.entity.RoleEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String phoneNumber;
    private String password;
    private Set<RoleDto> roles;

}

