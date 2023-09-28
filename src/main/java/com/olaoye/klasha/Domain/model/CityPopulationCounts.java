package com.olaoye.klasha.Domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CityPopulationCounts {

    private String year;

    private String value;

    private String sex;

    private String reliability;

}
