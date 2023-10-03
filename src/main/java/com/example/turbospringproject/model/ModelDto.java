package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.BrandEntity;
import com.example.turbospringproject.dao.entity.SubModelEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class ModelDto {
    private String name;
    private List<SubModelDto> subModels;

}
