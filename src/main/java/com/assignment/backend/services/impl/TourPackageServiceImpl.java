package com.assignment.backend.services.impl;

import com.assignment.backend.dto.TourPackageRequestDTO;
import com.assignment.backend.dto.TourPackageResponseDTO;
import com.assignment.backend.entities.TourPackage;
import com.assignment.backend.exceptions.TourPackageNotFoundException;
import com.assignment.backend.mapper.TourPackageMapper;
import com.assignment.backend.repositories.TourPackageRepository;
import com.assignment.backend.services.TourPackageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
public class TourPackageServiceImpl implements TourPackageService {

    private final TourPackageRepository tourPackageRepository;

    @Override
    public TourPackageResponseDTO addTourPackage(TourPackageRequestDTO tourPackageRequestDTO) {
        TourPackage tourPackage = TourPackageMapper.toEntity(tourPackageRequestDTO);
        TourPackage saveTourPackage = tourPackageRepository.save(tourPackage);
        TourPackageResponseDTO tourPackageResponseDTO = TourPackageMapper.toResponseDTO(saveTourPackage);
        tourPackageResponseDTO.setDiscountedPrice(calculateDiscountedPrice(tourPackageResponseDTO.getActualPrice(), tourPackageResponseDTO.getPercentageDiscount()));
        return tourPackageResponseDTO;
    }

    @Override
    public List<TourPackageResponseDTO> getAllTourPackages() {
        List<TourPackage> tourPackages = tourPackageRepository.findAll();
        return tourPackages.stream().map(tourPackage -> {
            BigDecimal discount = calculateDiscountedPrice(tourPackage.getActualPrice(), tourPackage.getPercentageDiscount());
            TourPackageResponseDTO tourPackageResponseDTO = TourPackageMapper.toResponseDTO(tourPackage);
            tourPackageResponseDTO.setDiscountedPrice(discount);
            return tourPackageResponseDTO;
        }).toList();
    }

    @Override
    public TourPackageResponseDTO getTourPackageById(Long id) {
        TourPackage tourPackage = tourPackageRepository.findById(id).orElseThrow(() -> new TourPackageNotFoundException(id));
        TourPackageResponseDTO tourPackageResponseDTO = TourPackageMapper.toResponseDTO(tourPackage);
        tourPackageResponseDTO.setDiscountedPrice(calculateDiscountedPrice(tourPackageResponseDTO.getActualPrice(), tourPackageResponseDTO.getPercentageDiscount()));
        return tourPackageResponseDTO;
    }

    @Override
    public List<TourPackageResponseDTO> searchTourPackageByLocation(String location) {
        List<TourPackage> tourPackages = tourPackageRepository.findByLocationContainsIgnoreCase(location);

        if (tourPackages.isEmpty()) {
            return List.of();
        }

        return tourPackages.stream().map(tourPackage -> {
            BigDecimal discount = calculateDiscountedPrice(tourPackage.getActualPrice(), tourPackage.getPercentageDiscount());
            TourPackageResponseDTO tourPackageResponseDTO = TourPackageMapper.toResponseDTO(tourPackage);
            tourPackageResponseDTO.setDiscountedPrice(discount);
            return tourPackageResponseDTO;
        }).toList();
    }

    private BigDecimal calculateDiscountedPrice(BigDecimal actualPrice, Integer discountInPercentage) {
        BigDecimal discount = actualPrice
                .multiply(BigDecimal.valueOf(discountInPercentage))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        return actualPrice.subtract(discount);
    }
}
