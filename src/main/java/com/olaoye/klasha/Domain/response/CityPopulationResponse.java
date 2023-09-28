package com.olaoye.klasha.Domain.response;

import com.olaoye.klasha.Domain.model.CityPopulation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CityPopulationResponse {
    private String error;

    private String msg;

    private CityPopulation data;


}
