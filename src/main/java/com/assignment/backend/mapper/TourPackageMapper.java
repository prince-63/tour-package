package com.assignment.backend.mapper;

import com.assignment.backend.dto.TourRequestDTO;
import com.assignment.backend.dto.TourResponseDTO;
import com.assignment.backend.entities.TourPackage;

public class TourPackageMapper {

    public static TourPackage toEntity(TourRequestDTO tourRequestDTO) {
        TourPackage tourPackage = new TourPackage();
        tourPackage.setTitle(tourRequestDTO.getTitle());
        tourPackage.setDescription(tourRequestDTO.getDescription());
        tourPackage.setLocation(tourRequestDTO.getLocation());
        tourPackage.setDuration(tourRequestDTO.getDuration());
        tourPackage.setDiscountInPercentage(tourRequestDTO.getDiscountInPercentage());
        tourPackage.setActualPrice(tourRequestDTO.getActualPrice());
        return tourPackage;
    }

    public static TourResponseDTO toResponseDTO(TourPackage tourPackage) {
        TourResponseDTO tourResponseDTO = new TourResponseDTO();
        tourResponseDTO.setId(tourPackage.getId());
        tourResponseDTO.setTitle(tourPackage.getTitle());
        tourResponseDTO.setDescription(tourPackage.getDescription());
        tourResponseDTO.setLocation(tourPackage.getLocation());
        tourResponseDTO.setDuration(tourPackage.getDuration());
        tourResponseDTO.setDiscountInPercentage(tourPackage.getDiscountInPercentage());
        tourResponseDTO.setActualPrice(tourPackage.getActualPrice());
        tourResponseDTO.setDiscountedPrice(tourPackage.getDiscountedPrice());
        return tourResponseDTO;
    }
}