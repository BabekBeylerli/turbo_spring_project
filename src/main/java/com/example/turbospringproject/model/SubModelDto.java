package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.ModelEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubModelDto {
    private String name;
    private ModelEntity model;
}
