package com.example.turbospringproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/v1/auth/register").permitAll()
                                .requestMatchers("/v1/auth/login").permitAll()
                                .requestMatchers("/v1/auth/user/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers("/v1/products/public/**").permitAll()
                                .requestMatchers("/v1/carSalons/public/**").permitAll()
                                .requestMatchers("/v1/products/user/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers("/v1/brands/admin/**").hasRole("ADMIN")
                                .requestMatchers("/v1/carSalons/admin/**").hasRole("ADMIN")
                                .requestMatchers("/v1/cities/admin/**").hasRole("ADMIN")
                                .requestMatchers("/v1/models/admin/**").hasRole("ADMIN")
                                .requestMatchers("/v1/subModels/admin/**").hasRole("ADMIN")
                                .requestMatchers(permitSwagger).permitAll()
                                .anyRequest().authenticated());
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsServicess() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        UserDetails user = users
                .username("user")
                .password("password")
                .roles("USER")
                .authorities("READ")
                .build();

        UserDetails admin = users
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .authorities("READ", "CREATE", "DELETE")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
    public static String[] permitSwagger = {
            "/api/v1/auth/**",
            "v3/api-docs/**",
            "v3/api-docs.yanl",
            "swagger-ui/**",
            "swagger-ui.html"
    };
}
