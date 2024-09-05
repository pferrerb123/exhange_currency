package com.example.RetoTecnico_SpringBoot.infrastructure.feign;

import com.example.RetoTecnico_SpringBoot.application.dto.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchangeRateClient", url = "https://open.er-api.com/v6")
public interface ExchangeRateClient {
    @GetMapping("/latest/{currency}")
    ExchangeRateResponse getExchangeRates(@PathVariable("currency") String currency);
}