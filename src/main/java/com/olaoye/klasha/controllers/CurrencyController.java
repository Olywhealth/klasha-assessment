package com.olaoye.klasha.controllers;

import com.olaoye.klasha.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping(value = "/currency-conversion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> convertCurrency(@RequestParam(name = "country") String country,
                                                  @RequestParam(name = "amount") String amount,
                                                  @RequestParam(name = "currency")String currency){
        return new ResponseEntity<>(
                currencyService.convertCurrency(country,amount,currency),
                HttpStatus.OK);
    }

}
