package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.ModelEntity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BrandDto {
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Should contain only alphabetic characters.")
    private String name;
    private List<ModelDto> model;

}
