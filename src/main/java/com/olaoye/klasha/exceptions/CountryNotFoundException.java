package com.olaoye.klasha.exceptions;

public class CountryNotFoundException extends CountriesAndCitiesApiException {

    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "Country";
    private final Object objectId;

    public CountryNotFoundException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("%s with name %s does not exist, or cannot be found in record.", ENTITY_NAME, objectId);
    }
}
