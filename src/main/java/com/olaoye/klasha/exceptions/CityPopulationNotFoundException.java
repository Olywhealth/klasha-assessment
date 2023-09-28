package com.olaoye.klasha.exceptions;

public class CityPopulationNotFoundException extends CountriesAndCitiesApiException{
    private static final Long serialVersionUID = 1L;

    private static final String ENTITY_NAME = "City population";

    private final Object objectId;

    public CityPopulationNotFoundException(Object objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        return String.format("%s of %s data not found in record.", ENTITY_NAME, objectId);
    }
}
