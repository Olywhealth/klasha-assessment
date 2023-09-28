package com.olaoye.klasha.services;

import com.olaoye.klasha.Domain.response.CityPopulationResponse;
import com.olaoye.klasha.Domain.response.PopulousCitiesResponse;

import java.util.List;

public interface CityService {
    /**
     * @return the top <numberOfCities> cities in order of cityPopulation.
     * If there are not enough cities, return the available ones;
     */
    List<PopulousCitiesResponse> sortedCitiesOfItalyGhanaNewZealand(String numberOfCities);

    CityPopulationResponse getCityPopulation(String cityName);


}
