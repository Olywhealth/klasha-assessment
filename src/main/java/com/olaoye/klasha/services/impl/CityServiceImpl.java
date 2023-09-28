package com.olaoye.klasha.services.impl;

import com.google.gson.Gson;
import com.olaoye.klasha.Domain.response.CityPopulationResponse;
import com.olaoye.klasha.Domain.response.CountryCitiesResponse;
import com.olaoye.klasha.Domain.response.PopulousCitiesResponse;
import com.olaoye.klasha.api.ApiClient;
import com.olaoye.klasha.constants.CountriesNowConfigProperties;
import com.olaoye.klasha.exceptions.CityPopulationNotFoundException;
import com.olaoye.klasha.exceptions.InvalidNumberException;
import com.olaoye.klasha.services.CityService;
import com.olaoye.klasha.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CountriesNowConfigProperties config;
    @Value("${countries.now.baseUrl}")
    private String baseUrl;

    private final CountryService countryService;

    @Override
    public List<PopulousCitiesResponse> sortedCitiesOfItalyGhanaNewZealand(String numberOfCities) {
        long cityNumbers = Long.parseLong(numberOfCities);
        if (cityNumbers < 1) {
            throw new InvalidNumberException(cityNumbers);
        }
        String[] countryCodes = {"italy", "ghana", "new zealand"};
        List<PopulousCitiesResponse> sortedCities = new ArrayList<>();
        for (String countryCode : countryCodes) {
            CountryCitiesResponse countryCities = countryService.getCitiesInCountry(countryCode);
            for (String city : countryCities.getData()) {
                PopulousCitiesResponse populousCity = new PopulousCitiesResponse();
                populousCity.setCityName(city);

                long population = getLatestPopulation(city);
                populousCity.setPopulation(population);

                sortedCities.add(populousCity);
            }
        }

        sortedCities.sort(Comparator.comparingLong(PopulousCitiesResponse::getPopulation).reversed());
        if (cityNumbers < sortedCities.size()) {
            sortedCities = sortedCities.subList(0, (int) cityNumbers);
        }

        if (sortedCities.isEmpty()) {
            throw new CityPopulationNotFoundException("Italy, New Zealand, Ghana");
        }

        return sortedCities;
    }


    @Override
    public CityPopulationResponse getCityPopulation(String city) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequestCity(baseUrl.concat(config.getCityPopulation()), city);
            Gson gson = new Gson();
            CityPopulationResponse cityPopulationResponse = gson.fromJson(jsonResponse, CityPopulationResponse.class);
            System.out.println(cityPopulationResponse.toString());

            return cityPopulationResponse;
        } catch (Exception e) {
            throw new CityPopulationNotFoundException(city);
        }
    }

    public Long getLatestPopulation(String city) {
        CityPopulationResponse populationResponse = getCityPopulation(city.toLowerCase());
        if(populationResponse.getData() == null || populationResponse.getData().getPopulationCounts()== null ){
            return 0L;
        }
        String population = populationResponse.
                getData()
                .getPopulationCounts().get(0).getValue();
        System.out.println("population = " + population);

        if(population == null){
          return 0L;
      }
        return Long.valueOf(population);
    }
}
