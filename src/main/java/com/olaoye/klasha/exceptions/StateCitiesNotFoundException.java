package com.olaoye.klasha.exceptions;

public class StateCitiesNotFoundException extends CountriesAndCitiesApiException{

    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "Cities";

    private final Object objectId;
    private final String country;

    public StateCitiesNotFoundException(Object objectId, String country) {
        this.objectId = objectId;
        this.country = country;
    }

    @Override
    public String getMessage() {
        return String.format("Data of %s in %s states of %s cannot be found in record", ENTITY_NAME, objectId,country );
    }
}
