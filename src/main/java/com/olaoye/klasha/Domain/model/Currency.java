package com.olaoye.klasha.Domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Currency {

    private String name;

    private String currency;

    private String iso2;

    private String iso3;

}
