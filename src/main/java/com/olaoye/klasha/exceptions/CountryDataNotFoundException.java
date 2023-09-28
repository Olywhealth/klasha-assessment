package com.olaoye.klasha.exceptions;

public class CountryDataNotFoundException extends  CountriesAndCitiesApiException{
    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "Country";

    private final Object objectId;

    public CountryDataNotFoundException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("Data of %s with name %s does not exist, or cannot be found in record", ENTITY_NAME, objectId);
    }
}
