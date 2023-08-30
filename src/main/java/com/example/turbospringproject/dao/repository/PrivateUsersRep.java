package com.example.turbospringproject.dao.repository;

import com.example.turbospringproject.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivateUsersRep extends JpaRepository<UserEntity,Integer> {
}
