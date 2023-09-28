package com.olaoye.klasha.constants;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "countries.now")
@Component
@Setter
@Getter
public class CountriesNowConfigProperties {

    private String cityPopulation;
    private String countryPopulation;
    private String countryCapital;
    private String stateInCountry;
    private String citiesInState;
    private String countryLocation;
    private String countryIso;
    private String countryCurrency;
    private String citiesInCountry;

}
