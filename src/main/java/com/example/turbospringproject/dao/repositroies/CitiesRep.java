package com.example.turbospringproject.dao.repositroies;

import com.example.turbospringproject.dao.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRep extends JpaRepository<Cities,Integer> {
}
