package com.diptam.controller;

import com.diptam.exception.ApiRequestException;
import com.diptam.service.CurrencyExchangeService;
import com.diptam.model.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService service;

    @Autowired
   Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> getExchange(@PathVariable String from, @PathVariable String to) throws ApiRequestException {
        String port = environment.getProperty("local.server.port");
        log.info("Request received : From Currency - "+from+" : To Currency - "+to+"  >>> Server Port : "+port);
        Optional<CurrencyExchange> body = service.findByCurrencyFromAndCurrencyTo(from, to);
        if(body.isPresent()){
            return ResponseEntity.ok(body.get());
        }else{
           throw new ApiRequestException("No Data Found");
        }
    }
}
