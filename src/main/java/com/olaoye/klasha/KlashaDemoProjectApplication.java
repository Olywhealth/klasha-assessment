package com.olaoye.klasha;

import com.olaoye.klasha.constants.CountriesNowConfigProperties;
import com.olaoye.klasha.constants.CsvCurrencyConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CsvCurrencyConstants.class)
//@EnableConfigurationProperties(CountriesNowConfigProperties.class)
public class KlashaDemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KlashaDemoProjectApplication.class, args);
        loadCurrencyConstants(); // This calls the method to load currency constants

    }
    private static void loadCurrencyConstants() {
        CsvCurrencyConstants currencyConstants = new CsvCurrencyConstants();
        currencyConstants.init();
    }


}
