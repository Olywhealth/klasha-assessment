package com.olaoye.klasha.Domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CountryCitiesResponse {

    private String error;

    private String msg;

    private List<String> data;

}
