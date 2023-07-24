package com.example.pharmacyMapProject.pharmacy.service;

import com.example.pharmacyMapProject.pharmacy.entity.Pharmacy;
import com.example.pharmacyMapProject.pharmacy.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacyRepositoryService {

    private final PharmacyRepository pharmacyRepository;

    @Transactional
    public void updateAddress(Long id, String address) {
        Pharmacy entity = pharmacyRepository.findById(id).orElse(null);

        if (Objects.isNull(address)) {
            log.error("[PharmacyRepositoryService updateAddress] not find id : {}", id);
            return;
        }

        entity.changePharmacyAddress(address);
    }

    @Transactional
    public List<Pharmacy> saveAll(List<Pharmacy> pharmacyList) {
        if (CollectionUtils.isEmpty(pharmacyList)) return Collections.emptyList();
        return pharmacyRepository.saveAll(pharmacyList);
    }

    @Transactional(readOnly = true)
    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();

    }
}
