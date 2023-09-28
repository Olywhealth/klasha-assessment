package com.olaoye.klasha.exceptions;

public class CountryCapitalNotFoundException extends CountriesAndCitiesApiException{

    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "Capital";
    private final Object objectId;

    public CountryCapitalNotFoundException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("%s of country with name %s cannot be found in record.", ENTITY_NAME, objectId);
    }
}
