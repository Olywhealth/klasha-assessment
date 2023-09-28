package com.olaoye.klasha.exceptions;

public class CountryPopulationNotFoundException extends CountriesAndCitiesApiException{
    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "Population";

    private final Object objectId;

    public CountryPopulationNotFoundException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("%s of %s data cannot be found in record.", ENTITY_NAME, objectId);
    }
}
