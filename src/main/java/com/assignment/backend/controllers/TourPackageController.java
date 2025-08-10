package com.assignment.backend.controllers;

import com.assignment.backend.dto.ErrorResponseDTO;
import com.assignment.backend.dto.ResponseDTO;
import com.assignment.backend.dto.TourPackageRequestDTO;
import com.assignment.backend.dto.TourPackageResponseDTO;
import com.assignment.backend.services.TourPackageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(name = "Tour Package API", description = "Endpoints for managing tour packages")
public class TourPackageController {

    private final TourPackageService tourPackageService;

    @Operation(
        summary = "Add a new tour package",
        description = "Creates a new tour package with the given details.",
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Tour package created successfully",
                content = @Content(
                    schema = @Schema(implementation = ResponseDTO.class)
                )
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Invalid input",
                content = @Content(
                    schema = @Schema(implementation = ErrorResponseDTO.class)
                )
            )
        }
    )
    @PostMapping(ADD_TOUR_PACKAGE)
    public ResponseEntity<ResponseDTO<TourPackageResponseDTO>> addTourPackage(
            @Valid @RequestBody TourPackageRequestDTO tourPackageRequestDTO
    ) {
        TourPackageResponseDTO tourPackageResponseDTO = tourPackageService.addTourPackage(tourPackageRequestDTO);
        ResponseDTO<TourPackageResponseDTO> response = new ResponseDTO<>();
        response.setMessage(TOUR_PACKAGE_ADD_SUCCESSFULLY);
        response.setData(tourPackageResponseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
        summary = "Get all tour packages",
        description = "Retrieves a list of all available tour packages.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Tour packages retrieved successfully",
                content = @Content(
                    schema = @Schema(implementation = ResponseDTO.class)
                )
            )
        }
    )
    @GetMapping(GET_ALL_TOUR_PACKAGE)
    public ResponseEntity<ResponseDTO<List<TourPackageResponseDTO>>> getAllTourPackage() {
        List<TourPackageResponseDTO> tourPackageResponseDTOList = tourPackageService.getAllTourPackages();
        ResponseDTO<List<TourPackageResponseDTO>> response = new ResponseDTO<>();
        response.setMessage(TOUR_PACKAGE_RETRIEVED_SUCCESSFULLY);
        response.setData(tourPackageResponseDTOList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(
        summary = "Get tour package by ID",
        description = "Retrieves details of a tour package using its ID.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Tour package retrieved successfully",
                content = @Content(
                    schema = @Schema(implementation = ResponseDTO.class)
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Tour package not found",
                content = @Content(
                    schema = @Schema(implementation = ErrorResponseDTO.class)
                )
            )
        }
    )
    @GetMapping(GET_TOUR_PACKAGE_BY_ID)
    public ResponseEntity<ResponseDTO<TourPackageResponseDTO>> getTourPackageById(
            @Parameter(description = "ID of the tour package to retrieve", required = true)
            @PathVariable Long id
    ) {
        TourPackageResponseDTO tourPackageResponseDTO = tourPackageService.getTourPackageById(id);
        ResponseDTO<TourPackageResponseDTO> response = new ResponseDTO<>();
        response.setMessage(TOUR_PACKAGE_RETRIEVED_SUCCESSFULLY);
        response.setData(tourPackageResponseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(
        summary = "Search tour packages by location",
        description = "Searches for tour packages that match a given location keyword.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Tour packages retrieved successfully",
                content = @Content(
                    schema = @Schema(implementation = ResponseDTO.class)
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Tour package not found",
                content = @Content(
                    schema = @Schema(implementation = ErrorResponseDTO.class)
                )
            )
        }
    )
    @GetMapping(SEARCH_TOUR_PACKAGE)
    public ResponseEntity<ResponseDTO<List<TourPackageResponseDTO>>> searchTourPackageByLocation(
            @Parameter(description = "Location keyword to search for", required = true)
            @RequestParam String location
    ) {
        List<TourPackageResponseDTO> tourPackageResponseDTOList = tourPackageService.searchTourPackageByLocation(location);
        ResponseDTO<List<TourPackageResponseDTO>> response = new ResponseDTO<>();
        response.setMessage(TOUR_PACKAGE_RETRIEVED_SUCCESSFULLY);
        response.setData(tourPackageResponseDTOList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
