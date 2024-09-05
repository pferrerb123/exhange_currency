package com.example.RetoTecnico_SpringBoot.application.service;

import com.example.RetoTecnico_SpringBoot.application.dto.ExchangeRateResponse;
import com.example.RetoTecnico_SpringBoot.application.dto.ExchangeRequest;
import com.example.RetoTecnico_SpringBoot.application.dto.ExchangeResponse;
import com.example.RetoTecnico_SpringBoot.domain.model.ExchangeRateTransaction;
import com.example.RetoTecnico_SpringBoot.domain.repository.ExchangeRateTransactionRepository;
import com.example.RetoTecnico_SpringBoot.infrastructure.feign.ExchangeRateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateTransactionRepository repository;

    @Autowired
    private ExchangeRateClient exchangeRateClient;

    public ExchangeResponse convert(ExchangeRequest request) {

        ExchangeRateResponse rates = exchangeRateClient.getExchangeRates(request.getSourceCurrency());
        BigDecimal rate = BigDecimal.valueOf(rates.getRates().get(request.getTargetCurrency()));
        BigDecimal convertedAmount = request.getAmount().multiply(rate);


        ExchangeRateTransaction exchangeRateTransaction = new ExchangeRateTransaction();
        exchangeRateTransaction.setSourceCurrency(request.getSourceCurrency());
        exchangeRateTransaction.setTargetCurrency(request.getTargetCurrency());
        exchangeRateTransaction.setAmount(request.getAmount());
        exchangeRateTransaction.setExchangedAmount(convertedAmount);
        exchangeRateTransaction.setExchangeRate(rate);

        repository.save(exchangeRateTransaction);

        ExchangeResponse response = new ExchangeResponse();
        response.setOriginalAmount(request.getAmount());
        response.setExchangedAmount(convertedAmount);
        response.setSourceCurrency(request.getSourceCurrency());
        response.setTargetCurrency(request.getTargetCurrency());
        response.setExchangeRate(rate);

        return response;

    }

    public List<ExchangeRateTransaction> getAllTransactions() {
        return repository.findAll();
    }

    public ExchangeRateTransaction getTransactionById(Long id) {
        return repository.findById(id).orElse(null);
    }
}