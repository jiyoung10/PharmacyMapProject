package com.example.pharmacyMapProject.pharmacy.repository

import com.example.pharmacyMapProject.AbstractContainerBaseTest
import com.example.pharmacyMapProject.pharmacy.entity.Pharmacy
import com.example.pharmacyMapProject.pharmacy.service.PharmacyRepositoryService
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDateTime

class PharmacyRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private PharmacyRepository pharmacyRepository

    @Autowired
    private PharmacyRepositoryService pharmacyRepositoryService;

    // 각 메서드 실행 전 정리
    def setup() {
        pharmacyRepository.deleteAll()
    }

    def "PharmacyRepository save"() {
        given:
        def address = "서울특별시 성북구 종암동"
        def name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        def result = pharmacyRepository.save(pharmacy)

        then:
        result.getPharmacyAddress() == address
        result.getPharmacyName() == name
        result.getLatitude() == latitude
        result.getLongitude() == longitude
    }

    def "PharmacyRepository saveAll"() {
        given:
        def address = "서울특별시 성북구 종암동"
        def name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        pharmacyRepository.saveAll(Arrays.asList(pharmacy))
        def result = pharmacyRepository.findAll()

        then:
        result.size() == 1
    }

    def "PharmacyRepository update"() {
        given:
        def address = "서울특별시 성북구 종암동"
        def name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def updateAddress = "서울특별시 성북구"

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        def result = pharmacyRepository.save(pharmacy)

        pharmacyRepositoryService.updateAddress(result.getId(), updateAddress)
        def updatePharmacy = pharmacyRepository.findById(result.getId()).get()

        then:
        updatePharmacy.getPharmacyAddress() == updateAddress
    }

    def "BaseTimeEntity 등록"() {
        given:
        LocalDateTime now = LocalDateTime.now()
        String address = "서울 특별시 성북구 종암동"
        String name = "은혜 약국"

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .build()

        when:
        pharmacyRepository.save(pharmacy)
        def result = pharmacyRepository.findAll()

        then:
        result.get(0).getCreatedDate().isAfter(now)
        result.get(0).getModifiedDate().isAfter(now)
    }

}
