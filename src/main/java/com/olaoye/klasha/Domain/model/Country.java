package com.olaoye.klasha.Domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private Long id;

    private String name;

    private List<CityPopulation> cityPopulationCounts;

    private String capital;

    private String countryLocation;

    private String currency;

    private List<States> states;

    private Location Location;

    private String iso2;

    private String iso3;

}
