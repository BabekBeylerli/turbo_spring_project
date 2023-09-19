package com.example.turbospringproject.service.auth;
import com.example.turbospringproject.dao.entity.UserEntity;
import com.example.turbospringproject.dao.repository.UserRepository;
import com.example.turbospringproject.model.auth.AuthRequestDto;
import com.example.turbospringproject.model.auth.AuthenticationDto;
import com.example.turbospringproject.model.auth.UserRegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    public AuthenticationDto register(UserRegisterRequestDto requestDto) {
        //TODO: unique check exception
        var user = UserEntity.builder()
                .phoneNumber(requestDto.getPhoneNumber())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationDto authenticate(AuthRequestDto authRequestDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getPhoneNumber(),
                        authRequestDto.getPassword()
                )
        );

        UserEntity user = userRepository.findUserByPhoneNumber(authRequestDto.getPhoneNumber()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }

    public static UserEntity getUser() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
