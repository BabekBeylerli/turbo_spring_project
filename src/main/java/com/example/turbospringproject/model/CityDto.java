package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.ProductEntity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CityDto {
    private String name;
    private List<ProductLiteDto> product;
}
