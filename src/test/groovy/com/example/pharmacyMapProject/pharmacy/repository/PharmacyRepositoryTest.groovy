package com.example.pharmacyMapProject.pharmacy.repository

import com.example.pharmacyMapProject.AbstractContainerBaseTest
import com.example.pharmacyMapProject.pharmacy.entity.Pharmacy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

class PharmacyRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private PharmacyRepository pharmacyRepository

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

        // id로 객체 조회 후 update
        def updatePharmacy = pharmacyRepository.findById(result.getId()).get()
        updatePharmacy.update(result.getId(), updateAddress, name, latitude, longitude)
        def updateResult = pharmacyRepository.save(updatePharmacy)

        then:
        updateResult.getPharmacyAddress() == updateAddress
        updateResult.getPharmacyName() == name
        updateResult.getLatitude() == latitude
        updateResult.getLongitude() == longitude
    }

}
