package com.assignment.backend.services;

import com.assignment.backend.dto.TourPackageRequestDTO;
import com.assignment.backend.dto.TourPackageResponseDTO;

import java.util.List;

public interface TourPackageService {

    TourPackageResponseDTO addTourPackage(TourPackageRequestDTO tourRequestDTO);

    List<TourPackageResponseDTO> getAllTourPackages();

    TourPackageResponseDTO getTourPackageById(Long id);

}