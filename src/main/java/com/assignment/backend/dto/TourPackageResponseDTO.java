package com.assignment.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TourPackageResponseDTO {

    private Long id;

    private String title;

    private String description;

    private String location;

    private String duration;

    private Integer percentageDiscount;

    private BigDecimal actualPrice;

    private BigDecimal discountedPrice;

}
