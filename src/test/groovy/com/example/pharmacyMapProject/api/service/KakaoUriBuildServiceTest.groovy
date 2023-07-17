package com.example.pharmacyMapProject.api.service

import spock.lang.Specification

import java.nio.charset.StandardCharsets

class KakaoUriBuildServiceTest extends Specification {

    private KakaoUriBuildService kakaoUriBuildService

    def setup() {
        kakaoUriBuildService = new KakaoUriBuildService()
    }

    def "buildUriByAddressSearch - 한글 파라미터의 경우 정상적으로 인코딩"() {
        given:
        String address = "서울특별시 성북구"
        def charSet = StandardCharsets.UTF_8

        when:
        def uri = kakaoUriBuildService.buildUriByAddressSearch(address)
        def decodeResult = URLDecoder.decode(uri.toString(), charSet)

        then:
        decodeResult == "https://dapi.kakao.com/v2/local/search/address.json?query=서울특별시 성북구"
    }
}
