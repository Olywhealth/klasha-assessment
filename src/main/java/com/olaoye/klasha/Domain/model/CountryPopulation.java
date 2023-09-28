package com.olaoye.klasha.Domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryPopulation {

    private String country;

    private String code;

    private String iso3;

    private List<CountryPopulationCounts> populationCounts;

}
