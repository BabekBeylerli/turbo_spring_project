package com.example.turbospringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TurboAzApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurboAzApplication.class, args);
	}

}
