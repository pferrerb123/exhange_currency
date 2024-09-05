package com.example.RetoTecnico_SpringBoot.presentation.controller;

import com.example.RetoTecnico_SpringBoot.application.dto.ExchangeRequest;
import com.example.RetoTecnico_SpringBoot.application.service.ExchangeRateService;
import com.example.RetoTecnico_SpringBoot.application.dto.ExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService service;

    @PostMapping("/convert")
    public ResponseEntity<ExchangeResponse> convertCurrency(@RequestBody ExchangeRequest request) {

        ExchangeResponse response = service.convert(request);
        return ResponseEntity.ok(response);
    }
}
