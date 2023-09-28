package com.olaoye.klasha.services.impl;

import com.olaoye.klasha.Domain.model.CityPopulation;
import com.olaoye.klasha.Domain.model.CityPopulationCounts;
import com.olaoye.klasha.Domain.response.CityPopulationResponse;
import com.olaoye.klasha.Domain.response.CountryCitiesResponse;
import com.olaoye.klasha.Domain.response.PopulousCitiesResponse;
import com.olaoye.klasha.services.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class CityServiceImplTest {

    @InjectMocks
    private CityServiceImpl cityServiceImpl;

    @Mock
    private CountryService countryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cityServiceImpl = new CityServiceImpl(countryService);

    }

    @Test
    void getCitiesOf_IT_NZ_GH_ByDescPopulation() {
        CountryCitiesResponse italyCities = new CountryCitiesResponse();
        italyCities.setData(Arrays.asList("Rome", "Milan", "Naples"));
        when(countryService.getCitiesInCountry("italy")).thenReturn(italyCities);

        CountryCitiesResponse ghanaCities = new CountryCitiesResponse();
        ghanaCities.setData(Collections.singletonList("Accra"));
        when(countryService.getCitiesInCountry("ghana")).thenReturn(ghanaCities);

        CountryCitiesResponse newZealandCities = new CountryCitiesResponse();
        newZealandCities.setData(Arrays.asList("Auckland", "Wellington"));
        when(countryService.getCitiesInCountry("new zealand")).thenReturn(newZealandCities);

        List<PopulousCitiesResponse> result = cityServiceImpl.sortedCitiesOfItalyGhanaNewZealand("3");

        assertEquals(3, result.size());
        assertEquals("Rome", result.get(0).getCityName());
        assertEquals("Milan", result.get(1).getCityName());
        assertEquals("Naples", result.get(2).getCityName());

        verify(countryService, times(1)).getCitiesInCountry("italy");
        verify(countryService, times(1)).getCitiesInCountry("ghana");
        verify(countryService, times(1)).getCitiesInCountry("new zealand");
    }

    /**
     * Contains a staic feld, so i need to use some other mocking service
     */
//    @Test
//    void getCityPopulation() {
//        String city = "TestCity";
//        String jsonResponse = "{\"data\": {\"populationCounts\": [{\"value\": \"1000000\"}]}}";
//
//        when(cityServiceImpl.sendOkHttpRequestCity(anyString(), eq(city))).thenReturn(jsonResponse);
//
//        // Perform the test
//        CityPopulationResponse result = cityServiceImpl.getCityPopulation(city);
//
//        // Assertions
//        assertNotNull(result);
//        assertEquals("1000000", result.getData().getPopulationCounts().get(0).getValue());
//
//        verify(cityServiceImpl, times(1)).sendOkHttpRequestCity(anyString(), eq(city));
//
//    }

    @Test
    void getLatestPopulation() {

        // Prepare mock response
        CityPopulationResponse populationResponse = new CityPopulationResponse();
        CityPopulation populationData = new CityPopulation();

        List<CityPopulationCounts> populationCounts = new ArrayList<>();
        populationCounts.add(new CityPopulationCounts(null, "1000000", null, null));
        populationData.setPopulationCounts(populationCounts);
        populationResponse.setData(populationData);

        when(cityServiceImpl.getCityPopulation(anyString())).thenReturn(populationResponse);

        // Perform the test
        Long result = cityServiceImpl.getLatestPopulation("TestCity");

        // Assertions
        assertEquals(1000000L, result);

        verify(cityServiceImpl, times(1)).getCityPopulation(anyString());

        }

}
