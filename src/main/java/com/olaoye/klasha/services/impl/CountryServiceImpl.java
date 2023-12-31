package com.olaoye.klasha.services.impl;

import com.google.gson.Gson;
import com.olaoye.klasha.Domain.model.State;
import com.olaoye.klasha.Domain.response.*;
import com.olaoye.klasha.api.ApiClient;
import com.olaoye.klasha.constants.CountriesNowConfigProperties;
import com.olaoye.klasha.exceptions.*;
import com.olaoye.klasha.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountriesNowConfigProperties config;
    @Value("${countries.now.baseUrl}")
    private String baseUrl;

    @Override
    public String getCapitalCity(String country) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequest(baseUrl.concat(config.getCountryCapital()), country);
            Gson gson = new Gson();
            CountryResponse countryResponse = gson.fromJson(jsonResponse, CountryResponse.class);
            return countryResponse.getData().getCapital();
        } catch (Exception e) {
            throw new EntityNotFoundException("Entity not found");
        }

    }

    @Override
    public CountryPopulationResponse getCountryPopulation(String country) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequest(baseUrl.concat(config.getCountryPopulation()), country);
            Gson gson = new Gson();
            CountryPopulationResponse populationResponse = gson.fromJson(jsonResponse, CountryPopulationResponse.class);
            return populationResponse;
        } catch (Exception e) {
            throw new EntityNotFoundException("Entity not found");
        }
    }

    @Override
    public Iso2And3Response getCountryIso(String country) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequest(baseUrl.concat(config.getCountryIso()), country);
            Gson gson = new Gson();
            Iso2And3Response iso2And3Response = gson.fromJson(jsonResponse, Iso2And3Response.class);
            return iso2And3Response;
        } catch (Exception e) {
            throw new EntityNotFoundException("Entity not found");
        }
    }

    @Override
    public LocationResponse getLocation(String country) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequest(baseUrl.concat(config.getCountryLocation()), country);
            Gson gson = new Gson();
            LocationResponse locationResponse = gson.fromJson(jsonResponse, LocationResponse.class);
            return locationResponse;
        } catch (Exception e) {
            throw new EntityNotFoundException("Entity not found");
        }
    }

    @Override
    public StateCitiesResponse getCitiesInState(String country, String state) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequest(baseUrl.concat(config.getCitiesInState()), country, state);
            Gson gson = new Gson();
            StateCitiesResponse stateCitiesResponse = gson.fromJson(jsonResponse, StateCitiesResponse.class);
            return stateCitiesResponse;
        } catch (Exception e) {
            throw new EntityNotFoundException("Entity not found");
        }
    }

    @Override
    public CountryStatesResponse getStates(String country) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequest(baseUrl.concat(config.getStateInCountry()), country);
            Gson gson = new Gson();
            CountryStatesResponse countryStatesResponse = gson.fromJson(jsonResponse, CountryStatesResponse.class);
            return countryStatesResponse;
        } catch (Exception e) {
            throw new EntityNotFoundException("No entity found for entry "+country);
        }
    }

    @Override
    public CountryCitiesResponse getCitiesInCountry(String country) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequest(baseUrl.concat(config.getCitiesInCountry()), country);
            Gson gson = new Gson();
            CountryCitiesResponse countryStatesResponse = gson.fromJson(jsonResponse, CountryCitiesResponse.class);
            return countryStatesResponse;
        } catch (Exception e) {
            throw new EntityNotFoundException("No such country in our Database");
        }
    }

    @Override
    public String getCurrency(String country) {
        try {
            String jsonResponse = ApiClient.sendOkHttpRequest(baseUrl.concat(config.getCountryCurrency()), country);
            Gson gson = new Gson();
            CurrencyResponse currencyResponse = gson.fromJson(jsonResponse, CurrencyResponse.class);
            String currency = currencyResponse.getData().getCurrency();
            return currency;
        } catch (Exception e) {
            throw  new EntityNotFoundException("No such currency");
        }
    }

    @Override
    public List<CountryStateAndCitiesResponse> getCitiesAndStatesInCountry(String country) {

        List<CountryStateAndCitiesResponse> countryStateAndCitiesList = new ArrayList<>();
        CountryStatesResponse allStatesInTheCountryObject = getStates(country);
        if (allStatesInTheCountryObject == null) {
            throw new EntityNotFoundException("Entity not found ");
        }
        List<String> allStateNames = allStatesInTheCountryObject.getData().getStates().stream().map(State::getName).collect(Collectors.toList());

        for (String stateName : allStateNames) {
            CountryStateAndCitiesResponse countryStateAndCities = new CountryStateAndCitiesResponse();
            countryStateAndCities.setStateName(stateName);
            StateCitiesResponse citiesObject = getCitiesInState(country, stateName);
            List<String> cityNames = citiesObject.getData();
            countryStateAndCities.setCityNames(cityNames);

            countryStateAndCitiesList.add(countryStateAndCities);
        }
        return countryStateAndCitiesList;
    }

    @Override
    public CountryDataResponse getCountryData(String country) {
        CountryDataResponse countryDataResponse = CountryDataResponse.builder()
                .capitalCity(getCapitalCity(country))
                .population(getCountryPopulation(country))
                .location(getLocation(country))
                .currency(getCurrency(country))
                .iso2And3(getCountryIso(country))
                .build();
        if (countryDataResponse == null) {
            throw new EntityNotFoundException("Entity not found ");
        }
        return countryDataResponse;
    }
}
