package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.ProductEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SupplyDto {
    private boolean alloyWheels;
    private boolean abs;
    private boolean hatch;
    private boolean rainSensor;
    private boolean centralLocking;
    private boolean parkingRadar;
    private boolean airConditioning;
    private boolean seatHeating;
    private boolean leatherSalon;
    private boolean xenonLamps;
    private boolean rearViewCamera;
    private boolean sideCurtains;
    private boolean seatVentilation;
}
