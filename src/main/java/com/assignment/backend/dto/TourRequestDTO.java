package com.assignment.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TourRequestDTO {

    private String title;

    private String description;

    private String location;

    private String duration;

    private Integer discountInPercentage;

    private BigDecimal actualPrice;

}
