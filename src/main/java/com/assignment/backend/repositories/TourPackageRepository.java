package com.assignment.backend.repositories;

import com.assignment.backend.entities.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourPackageRepository extends JpaRepository<TourPackage, Long> {
    List<TourPackage> findByLocationContainsIgnoreCase(String location);
}
