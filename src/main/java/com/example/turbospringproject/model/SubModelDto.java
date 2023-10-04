package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.ModelEntity;
import com.example.turbospringproject.dao.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubModelDto {
    private String name;
}
