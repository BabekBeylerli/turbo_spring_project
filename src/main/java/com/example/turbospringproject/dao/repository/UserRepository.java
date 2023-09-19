package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
Optional<UserEntity> findUserByPhoneNumber(String phoneNumber);
}
