package com.olaoye.klasha.Domain.response;

import com.olaoye.klasha.Domain.model.CountryPopulation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountryPopulationResponse {

    private String error;

    private String msg;

    private CountryPopulation data;

}
