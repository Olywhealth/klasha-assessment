package com.olaoye.klasha.Domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CountryPopulationCounts {

    private Long year;
    private Long value;

}
