package com.example.turbospringproject.dao.repositroies;

import com.example.turbospringproject.dao.entity.PrivateUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivateUsersRep extends JpaRepository<PrivateUsers,Integer> {
}
