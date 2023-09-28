package com.olaoye.klasha.exceptions;

public class CountryCitiesNotFoundException  extends CountriesAndCitiesApiException{

    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "Cities";

    private final Object objectId;

    public CountryCitiesNotFoundException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("%s of %s cannot be found in record", ENTITY_NAME, objectId);
    }


}
