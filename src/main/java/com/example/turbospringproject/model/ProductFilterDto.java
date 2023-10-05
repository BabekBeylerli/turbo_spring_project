package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.enums.EProduct;
import com.example.turbospringproject.dao.entity.enums.ProductOwnerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterDto {
    private List<String> banType;
    private List<String> color;
    private Double upPrice;
    private Double downPrice;
    private String priceType;
    private List<String> fuelType;
    private List<String> gear;
    private List<String> gearBox;
    private Double upEngineVolume;
    private Double downEngineVolume;
    private Integer upEnginePower;
    private Integer downEnginePower;
    private List<Integer> owners;
    private Integer upYear;
    private Integer downYear;
    private List<String> market;
    private List<Integer> seatsNumber;
    private String subModelName;
    private String brandName;
    private List<String> cityName;
    private String modelName;
    private boolean stroke;
    private boolean colored;
    private boolean accident;
    private boolean credit;
    private boolean barter;
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
    private ProductOwnerType productOwnerType;

}
