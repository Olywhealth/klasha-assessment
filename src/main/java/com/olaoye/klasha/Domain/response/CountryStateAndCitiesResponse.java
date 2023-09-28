package com.olaoye.klasha.Domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountryStateAndCitiesResponse {

    private String stateName;

    private List<String> cityNames;
}
