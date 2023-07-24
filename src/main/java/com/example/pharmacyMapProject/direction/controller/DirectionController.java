package com.example.pharmacyMapProject.direction.controller;

import com.example.pharmacyMapProject.direction.service.DirectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionService directionService;

    @GetMapping("/dir/{encodeId}")
    public String searchDirection(@PathVariable("encodeId") String encodeId) {

        String result = directionService.findDirectionUrlById(encodeId);

        log.info("[DirectionController searchDirection] direction url : {}", result);

        return "redirect: " + result;
    }



}
