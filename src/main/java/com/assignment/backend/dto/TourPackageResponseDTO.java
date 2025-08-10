package com.assignment.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "Response DTO for Tour Package details")
public class TourPackageResponseDTO {

    @Schema(description = "Unique identifier of the tour package", example = "1")
    private Long id;

    @Schema(description = "Title of the tour package", example = "Himalayan Trek Adventure")
    private String title;

    @Schema(description = "Detailed description of the tour", example = "14-day trek through the Himalayas with expert guides")
    private String description;

    @Schema(description = "Location of the tour", example = "Himalayas, India")
    private String location;

    @Schema(description = "Duration of the tour", example = "14Days/13Nights")
    private String duration;

    @Schema(description = "URL of the tour's main image", example = "https://images.unsplash.com/photo-1598275277521-1885382d523a")
    private String imageUrl;

    @Schema(description = "Percentage discount on the actual price", example = "17")
    private Integer percentageDiscount;

    @Schema(description = "Original price of the tour", example = "1200.00")
    private BigDecimal actualPrice;

    @Schema(description = "Discounted price after applying percentage discount", example = "996.00")
    private BigDecimal discountedPrice;
}
