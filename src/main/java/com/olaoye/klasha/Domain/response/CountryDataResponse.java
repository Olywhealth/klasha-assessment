package com.olaoye.klasha.Domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountryDataResponse {

    private CountryPopulationResponse population;

    private String capitalCity;

    private LocationResponse location;

    private String currency;

    private Iso2And3Response iso2And3;


}
