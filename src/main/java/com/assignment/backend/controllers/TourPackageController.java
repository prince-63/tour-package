package com.assignment.backend.controllers;

import com.assignment.backend.dto.ResponseDTO;
import com.assignment.backend.dto.TourPackageRequestDTO;
import com.assignment.backend.dto.TourPackageResponseDTO;
import com.assignment.backend.services.TourPackageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.assignment.backend.constants.SuccessMessageConstants.TOUR_PACKAGE_ADD_SUCCESSFULLY;
import static com.assignment.backend.constants.SuccessMessageConstants.TOUR_PACKAGE_RETRIEVED_SUCCESSFULLY;
import static com.assignment.backend.constants.TourPackageApiConstants.*;

@RestController
@AllArgsConstructor
public class TourPackageController {

    private final TourPackageService tourPackageService;

    @PostMapping(ADD_TOUR_PACKAGE)
    public ResponseEntity<ResponseDTO<TourPackageResponseDTO>> addTourPackage(@RequestBody TourPackageRequestDTO tourPackageRequestDTO) {
        TourPackageResponseDTO tourPackageResponseDTO = tourPackageService.addTourPackage(tourPackageRequestDTO);
        ResponseDTO<TourPackageResponseDTO> response = new ResponseDTO<>();
        response.setMessage(TOUR_PACKAGE_ADD_SUCCESSFULLY);
        response.setData(tourPackageResponseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(GET_ALL_TOUR_PACKAGE)
    public ResponseEntity<ResponseDTO<List<TourPackageResponseDTO>>> getAllTourPackage() {
        List<TourPackageResponseDTO> tourPackageResponseDTOList = tourPackageService.getAllTourPackages();
        ResponseDTO<List<TourPackageResponseDTO>> response = new ResponseDTO<>();
        response.setMessage(TOUR_PACKAGE_RETRIEVED_SUCCESSFULLY);
        response.setData(tourPackageResponseDTOList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(GET_TOUR_PACKAGE_BY_ID)
    public ResponseEntity<ResponseDTO<TourPackageResponseDTO>> getTourPackageById(@PathVariable Long id) {
        TourPackageResponseDTO tourPackageResponseDTO = tourPackageService.getTourPackageById(id);
        ResponseDTO<TourPackageResponseDTO> response = new ResponseDTO<>();
        response.setMessage(TOUR_PACKAGE_RETRIEVED_SUCCESSFULLY);
        response.setData(tourPackageResponseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
