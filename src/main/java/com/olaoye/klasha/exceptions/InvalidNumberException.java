package com.olaoye.klasha.exceptions;

public class InvalidNumberException extends CountriesAndCitiesApiException{
    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "Number of Cities";

    private final Object objectId;

    public InvalidNumberException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("%s input is invalid. %s input should be 1 or higher.", objectId, ENTITY_NAME);
    }
}
