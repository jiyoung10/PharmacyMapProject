package com.example.pharmacyMapProject.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "pharmacy")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {

    @Id // PK 값을 자동 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pharmacyName;
    private String pharmacyAddress;
    private double latitude;
    private double longitude;

    public Pharmacy update(Long id, String pharmacyAddress, String pharmacyName, double latitude, double longitude) {
        return new Pharmacy(
                this.id = id,
                this.pharmacyAddress = pharmacyAddress,
                this.pharmacyName = pharmacyName,
                this.latitude = latitude,
                this.longitude = longitude
        );

    }

}
