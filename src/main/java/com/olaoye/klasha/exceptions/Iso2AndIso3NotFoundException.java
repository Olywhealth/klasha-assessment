package com.olaoye.klasha.exceptions;

public class Iso2AndIso3NotFoundException extends CountriesAndCitiesApiException{
    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "Iso2 and Iso3";

    private final Object objectId;

    public Iso2AndIso3NotFoundException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("%s of %s cannot be found in record", ENTITY_NAME, objectId);
    }
}
