package com.assignment.backend.mapper;

import com.assignment.backend.dto.TourPackageRequestDTO;
import com.assignment.backend.dto.TourPackageResponseDTO;
import com.assignment.backend.entities.TourPackage;

public class TourPackageMapper {

    public static TourPackage toEntity(TourPackageRequestDTO tourPackageRequestDTO) {
        TourPackage tourPackage = new TourPackage();
        tourPackage.setTitle(tourPackageRequestDTO.getTitle());
        tourPackage.setDescription(tourPackageRequestDTO.getDescription());
        tourPackage.setLocation(tourPackageRequestDTO.getLocation());
        tourPackage.setDuration(tourPackageRequestDTO.getDuration());
        tourPackage.setPercentageDiscount(tourPackageRequestDTO.getPercentageDiscount());
        tourPackage.setActualPrice(tourPackageRequestDTO.getActualPrice());
        return tourPackage;
    }

    public static TourPackageResponseDTO toResponseDTO(TourPackage tourPackage) {
        TourPackageResponseDTO tourPackageResponseDTO = new TourPackageResponseDTO();
        tourPackageResponseDTO.setId(tourPackage.getId());
        tourPackageResponseDTO.setTitle(tourPackage.getTitle());
        tourPackageResponseDTO.setDescription(tourPackage.getDescription());
        tourPackageResponseDTO.setLocation(tourPackage.getLocation());
        tourPackageResponseDTO.setDuration(tourPackage.getDuration());
        tourPackageResponseDTO.setPercentageDiscount(tourPackage.getPercentageDiscount());
        tourPackageResponseDTO.setActualPrice(tourPackage.getActualPrice());
        return tourPackageResponseDTO;
    }
}