package com.olaoye.klasha.controllers;

import com.olaoye.klasha.Domain.response.PopulousCitiesResponse;
import com.olaoye.klasha.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;


    @GetMapping(value = "/populous-cities/{numberOfCities}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PopulousCitiesResponse>> retrievePopulousCitiesOf_IT_NZ_GH(@PathVariable("numberOfCities") String numberOfCities) {

        List<PopulousCitiesResponse> response = cityService.sortedCitiesOfItalyGhanaNewZealand(numberOfCities);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
