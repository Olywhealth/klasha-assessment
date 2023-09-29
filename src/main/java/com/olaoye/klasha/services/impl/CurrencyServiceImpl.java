package com.olaoye.klasha.services.impl;

import com.olaoye.klasha.exceptions.EntityNotFoundException;
import com.olaoye.klasha.services.CountryService;
import com.olaoye.klasha.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.olaoye.klasha.constants.CsvCurrencyConstants.*;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CountryService countryService;


    @Override
    public String convertCurrency(String country, String amount, String currency) {
        Long foreignCurrencyAmount = Long.valueOf(amount);

        BigDecimal roundedAmount;
        String localCurrency = countryService.getCurrency(country);

        double localCurrencyAmount;

        if (currency.equalsIgnoreCase("EUR") && localCurrency.equalsIgnoreCase("NGN")) {
            localCurrencyAmount = foreignCurrencyAmount * EUR_NGN;
            roundedAmount = BigDecimal.valueOf(localCurrencyAmount);
            return (localCurrency + roundedAmount);
        }

        if (currency.equalsIgnoreCase("USD") && localCurrency.equalsIgnoreCase("NGN")) {
            double product = foreignCurrencyAmount * USD_NGN;
            System.out.println(product);
            localCurrencyAmount = foreignCurrencyAmount * USD_NGN;
            System.out.println(localCurrencyAmount);
            roundedAmount = BigDecimal.valueOf(localCurrencyAmount);
            return (localCurrency + roundedAmount);
        }
        if (currency.equalsIgnoreCase("JPY") && localCurrency.equalsIgnoreCase("NGN")) {
            localCurrencyAmount = foreignCurrencyAmount * JPY_NGN;
            roundedAmount = BigDecimal.valueOf(localCurrencyAmount);
            return (localCurrency + roundedAmount);
        }
        if (currency.equalsIgnoreCase("GBP") && localCurrency.equalsIgnoreCase("NGN")) {
            localCurrencyAmount = foreignCurrencyAmount * GBP_NGN;
            roundedAmount = BigDecimal.valueOf(localCurrencyAmount);
            return (localCurrency + roundedAmount);
        }
        if (currency.equalsIgnoreCase("EUR") && localCurrency.equalsIgnoreCase("UGX")) {
            localCurrencyAmount = foreignCurrencyAmount * EUR_UGX;
            roundedAmount = BigDecimal.valueOf(localCurrencyAmount);
            return (localCurrency + roundedAmount);
        }
        if (currency.equalsIgnoreCase("USD") && localCurrency.equalsIgnoreCase("UGX")) {
            localCurrencyAmount = foreignCurrencyAmount * USD_UGX;
            roundedAmount = BigDecimal.valueOf(localCurrencyAmount);
            return (localCurrency + roundedAmount);
        }
        if (currency.equalsIgnoreCase("JPY") && localCurrency.equalsIgnoreCase("UGX")) {
            localCurrencyAmount = foreignCurrencyAmount * JPY_UGX;
            roundedAmount = BigDecimal.valueOf(localCurrencyAmount);
            return (localCurrency + roundedAmount);
        }
        if (currency.equalsIgnoreCase("GBP") && localCurrency.equalsIgnoreCase("UGX")) {
            localCurrencyAmount = foreignCurrencyAmount * GBP_UGX;
            roundedAmount = BigDecimal.valueOf(localCurrencyAmount);
            return (localCurrency + roundedAmount);
        } else throw new EntityNotFoundException("No entity found for parameter: "+country);


    }
}
