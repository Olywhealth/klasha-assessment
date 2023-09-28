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
public class CityPopulation {

    private String city;

    private String country;

    private List<CityPopulationCounts> populationCounts;


}
