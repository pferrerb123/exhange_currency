package com.example.RetoTecnico_SpringBoot.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ExchangeRateResponse {

    private String base_code;
    private Map<String, Double> rates;
}
