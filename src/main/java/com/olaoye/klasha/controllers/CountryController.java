package com.olaoye.klasha.controllers;

import com.olaoye.klasha.Domain.response.CountryDataResponse;
import com.olaoye.klasha.Domain.response.CountryStateAndCitiesResponse;
import com.olaoye.klasha.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/country")
@RequiredArgsConstructor
public class CountryController {


    private final CountryService countryService;

    @GetMapping(value = "/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDataResponse> retrieveCountryDetails(@RequestParam("country") String country  ){
        return new ResponseEntity<>(
                countryService.getCountryData(country),
                HttpStatus.OK);
    }


    @GetMapping(value = "/states-cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryStateAndCitiesResponse>> retrieveCitiesAndStatesInCountry(@RequestParam("country") String country  ){
        return new ResponseEntity<>(
                countryService.getCitiesAndStatesInCountry(country),
                HttpStatus.OK);
    }

}
