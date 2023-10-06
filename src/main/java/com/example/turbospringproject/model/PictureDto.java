package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.ProductEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PictureDto {
    private String image;
    @Min(value=1)
    private Integer sort;
}
