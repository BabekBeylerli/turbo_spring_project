package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.ProductEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarSituationDto {
    private boolean stroke;
    private boolean colored;
    private boolean accident;
    private boolean credit;
    private boolean barter;


}
