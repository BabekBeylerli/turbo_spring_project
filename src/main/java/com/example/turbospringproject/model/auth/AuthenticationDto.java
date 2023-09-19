package com.example.turbospringproject.model.auth;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDto {

    private String token;
}
