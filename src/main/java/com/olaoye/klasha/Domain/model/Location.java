package com.olaoye.klasha.Domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {

    private String name;

    private String iso2;

    @JsonProperty(namespace = "long")
    private String longitude;

    private String lat;

}
