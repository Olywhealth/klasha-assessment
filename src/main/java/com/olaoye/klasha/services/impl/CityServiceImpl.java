package com.olaoye.klasha.services.impl;

import com.google.gson.Gson;
import com.olaoye.klasha.Domain.response.CityPopulationResponse;
import com.olaoye.klasha.Domain.response.CountryCitiesResponse;
import com.olaoye.klasha.Domain.response.PopulousCitiesResponse;
import com.olaoye.klasha.api.ApiClient;
import com.olaoye.klasha.constants.CountriesNowConfigProperties;
import com.olaoye.klasha.exceptions.EntityNotFoundException;
import com.olaoye.klasha.services.CityService;
import com.olaoye.klasha.services.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityServiceImpl implements CityService {

    private final CountriesNowConfigProperties config;
    private final CountryService countryService;
    @Value("${countries.now.baseUrl}")
    private String baseUrl;

    @Override
    public List<PopulousCitiesResponse> sortedCitiesOfItalyGhanaNewZealand(Integer numberOfCities) {
        if (numberOfCities < 1) {
            throw new EntityNotFoundException("Invalid input: "+numberOfCities);
        }

        List<String> countryCodes = new ArrayList<>(Arrays.asList("italy", "ghana", "new zealand"));

        return countryCodes.stream()
                .flatMap(countryCode -> {
                    CountryCitiesResponse countryCities = countryService.getCitiesInCountry(countryCode);
                    return countryCities.getData().stream().map(city -> {
                        PopulousCitiesResponse populousCity = new PopulousCitiesResponse();
                        populousCity.setCityName(city);
                        long population = getLatestPopulation(city);
                        populousCity.setPopulation(population);
                        return populousCity;
                    });
                })
                .sorted(Comparator.comparingLong(PopulousCitiesResponse::getPopulation).reversed())
                .limit(numberOfCities)
                .collect(Collectors.toList());
    }


    @Override
    public CityPopulationResponse getCityPopulation(String city) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequest(baseUrl.concat(config.getCityPopulation()), city);
            Gson gson = new Gson();
            CityPopulationResponse cityPopulationResponse = gson.fromJson(jsonResponse, CityPopulationResponse.class);
            log.info("CITY POPULATION RESPONSE: {}", cityPopulationResponse);
            return cityPopulationResponse;
        } catch (Exception e) {
            throw new EntityNotFoundException("No entity found for your entry: " + city);
        }
    }

    public Long getLatestPopulation(String city) {
        CityPopulationResponse populationResponse = getCityPopulation(city.toLowerCase());
        if (populationResponse.getData() == null || populationResponse.getData().getPopulationCounts() == null) {
            return 0L;
        }
        String population = populationResponse.
                getData()
                .getPopulationCounts().get(0).getValue();
        log.info("LATEST POPULATION:  {}", population);
        if (population == null) {
            return 0L;
        }
        return Long.valueOf(population);
    }
}
