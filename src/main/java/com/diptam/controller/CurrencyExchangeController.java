package com.diptam.controller;

import com.diptam.service.CurrencyExchangeService;
import com.diptam.model.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService service;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> getExchange(@PathVariable String from, @PathVariable String to){
        log.info(from +" : "+ to);
        return ResponseEntity.ok(service.findByCurrencyFromAndCurrencyTo(from, to).orElse(new CurrencyExchange()));
    }
}