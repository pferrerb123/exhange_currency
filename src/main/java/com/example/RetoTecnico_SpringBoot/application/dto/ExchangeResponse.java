package com.example.RetoTecnico_SpringBoot.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExchangeResponse {
    private BigDecimal originalAmount;
    private BigDecimal exchangedAmount;
    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal exchangeRate;
}