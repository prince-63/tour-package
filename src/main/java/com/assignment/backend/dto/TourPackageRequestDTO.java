package com.assignment.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "Request DTO for creating or updating a Tour Package")
public class TourPackageRequestDTO {

    @Schema(description = "Title of the tour package", example = "Himalayan Trek Adventure")
    @NotEmpty(message = "Title should not be empty!")
    private String title;

    @Schema(description = "Detailed description of the tour", example = "A 14-day trek through the beautiful Himalayan mountain range with expert guides.")
    @NotEmpty(message = "Description should not be empty!")
    @Size(max = 1000, message = "The description length must be under 1000 words!")
    private String description;

    @Schema(description = "Location of the tour", example = "Himalayas, India")
    @NotEmpty(message = "Location should not be empty!")
    private String location;

    @Schema(description = "Duration of the tour", example = "14Days/13Nights")
    @NotEmpty(message = "Duration should not be empty!")
    private String duration;

    @Schema(description = "Percentage discount on the actual price", example = "17")
    @NotNull(message = "Discount percentage should not be null!")
    private Integer percentageDiscount;

    @Schema(description = "Original price of the tour", example = "1200.00")
    @NotNull(message = "Price not be null!")
    private BigDecimal actualPrice;
}
