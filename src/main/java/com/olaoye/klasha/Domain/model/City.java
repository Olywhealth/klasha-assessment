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
public class City {

    private String name;

    private List<CityPopulation> cityPopulation;

    private Country country;

    private Long populationCounts;


}
