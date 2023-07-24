package com.example.pharmacyMapProject.pharmacy.repository;

import com.example.pharmacyMapProject.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
