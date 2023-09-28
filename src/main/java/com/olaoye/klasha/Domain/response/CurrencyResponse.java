package com.olaoye.klasha.Domain.response;

import com.olaoye.klasha.Domain.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CurrencyResponse {
    private String error;

    private String msg;

    private Currency data;

}
