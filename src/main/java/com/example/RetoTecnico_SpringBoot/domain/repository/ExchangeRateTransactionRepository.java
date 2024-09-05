package com.example.RetoTecnico_SpringBoot.domain.repository;

import com.example.RetoTecnico_SpringBoot.domain.model.ExchangeRateTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateTransactionRepository extends JpaRepository<ExchangeRateTransaction, Long> {
}