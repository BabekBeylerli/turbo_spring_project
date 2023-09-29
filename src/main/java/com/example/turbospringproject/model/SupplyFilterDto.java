package com.example.turbospringproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyFilterDto {
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
