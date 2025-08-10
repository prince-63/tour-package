package com.assignment.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tour_package")
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private Integer discountInPercentage;

    private String title;

    @Column(length = 1000)
    private String description;

    private String duration;

    private BigDecimal actualPrice;

    private BigDecimal discountedPrice;

}