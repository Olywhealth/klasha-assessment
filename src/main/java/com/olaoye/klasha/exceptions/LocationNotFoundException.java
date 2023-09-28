package com.olaoye.klasha.exceptions;

public class LocationNotFoundException extends CountriesAndCitiesApiException {

    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "Location";

    private final Object objectId;

    public LocationNotFoundException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("%s of %s cannot be found in record", ENTITY_NAME, objectId);
    }
}
