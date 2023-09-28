package com.olaoye.klasha.exceptions;

public class StateNotFoundException extends CountriesAndCitiesApiException{
    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "State";

    private final Object objectId;

    public StateNotFoundException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("%s in %s cannot be found in record or does not exist", ENTITY_NAME, objectId);
    }
}
