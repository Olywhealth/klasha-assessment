package com.olaoye.klasha.Domain.response;

import com.olaoye.klasha.Domain.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocationResponse {

    private String error;

    private String msg;

    private Location data;

}
