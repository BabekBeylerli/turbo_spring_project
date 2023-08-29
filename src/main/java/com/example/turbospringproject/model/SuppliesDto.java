package com.example.turbospringproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SuppliesDto {
    private boolean alloyWheels;
    private boolean usa;
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
