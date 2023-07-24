package com.example.pharmacyMapProject.pharmacy.entity;

import com.example.pharmacyMapProject.BaseTimeEntity;
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
public class Pharmacy extends BaseTimeEntity {

    @Id // PK 값을 자동 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pharmacyName;
    private String pharmacyAddress;
    private double latitude;
    private double longitude;

    public void changePharmacyAddress(String address) {
        this.pharmacyAddress = address;
    }

}
