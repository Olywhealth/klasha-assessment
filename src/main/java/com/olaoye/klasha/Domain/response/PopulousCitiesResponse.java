package com.olaoye.klasha.Domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PopulousCitiesResponse {

    private String cityName;

    private Long population;
}
