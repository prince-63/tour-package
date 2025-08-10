package com.assignment.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TourPackageRequestDTO {

    @NotEmpty(message = "Title should not be empty!")
    private String title;

    @NotEmpty(message = "Description should not be empty!")
    @Size(max = 1000, message = "The description length must be under 1000 words!")
    private String description;

    @NotEmpty(message = "Location should not be empty!")
    private String location;

    @NotEmpty(message = "Duration should not be empty!")
    private String duration;

    @NotNull(message = "Discount percentage should not be null!")
    private Integer percentageDiscount;

    @NotNull(message = "Price not be null!")
    private BigDecimal actualPrice;

}
