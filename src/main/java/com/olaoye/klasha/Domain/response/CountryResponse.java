package com.olaoye.klasha.Domain.response;

import com.olaoye.klasha.Domain.model.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CountryResponse {

        private String error;

        private String msg;

        private Country data;

}
