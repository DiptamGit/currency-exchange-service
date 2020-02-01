package com.diptam.service;

import com.diptam.model.CurrencyExchange;
import com.diptam.repo.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository exchangeRepository;

    public Optional<CurrencyExchange> findById(Long id){
        return exchangeRepository.findById(id);
    }

    public List<CurrencyExchange> findAll(){
        return exchangeRepository.findAll();
    }

    public Optional<CurrencyExchange> findByCurrencyFromAndCurrencyTo(String from, String to){
        return exchangeRepository.findByCurrencyFromAndCurrencyTo(from, to);
    }
}
