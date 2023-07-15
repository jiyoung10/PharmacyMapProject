package com.example.pharmacyMapProject.api.service;

import com.example.pharmacyMapProject.api.dto.KakaoApiResponseDto;
import com.example.pharmacyMapProject.config.RestTemplateConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoAddressSearchService {

    private final KakaoUriBuildService kakaoUriBuildService;
    private final RestTemplate restTemplate;

    @Value(value = "${kakao.rest.api.key}")
    private final String kakaoRestApiKey;

    public KakaoApiResponseDto requestAddressSearch(String address) {

        if(ObjectUtils.isEmpty(address)) return null;

        URI uri = kakaoUriBuildService.buildUriByAddressSearch(address);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "KakaoAK " + kakaoRestApiKey);

        HttpEntity httpEntity = new HttpEntity<>(headers);

        // kakao api 호출
        return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, KakaoApiResponseDto.class).getBody();
    }
}
