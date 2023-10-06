package com.example.turbospringproject.model;

import com.example.turbospringproject.dao.entity.enums.ECarSalon;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSalonLiteDto {
    private String tittle;
    private ECarSalon type;
    private String description;
    private String activeTime;
    private String remark;
    private String logo;
    private String image;
    private Integer productsCount;
    @Min(value = 0)
    private Integer viewNumber;
    private String location;
    private List<CarSalonPhoneDto> phones;

}
