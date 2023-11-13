package com.example.sockwarehouse.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocksDTO {

    private String color;

    @Min(0)
    @Max(100)
    private Integer cottonPart;

    @Min(0)
    private Integer quantity;
}
