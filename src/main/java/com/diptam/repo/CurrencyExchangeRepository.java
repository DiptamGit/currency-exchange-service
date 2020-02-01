package com.diptam.repo;

import com.diptam.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    @Query(value = "select * from sakila.currency_exchange e where e.currency_from=?1 and currency_to=?2", nativeQuery = true)
    Optional<CurrencyExchange> findByCurrencyFromAndCurrencyTo(String currency_from, String currency_to);
}
