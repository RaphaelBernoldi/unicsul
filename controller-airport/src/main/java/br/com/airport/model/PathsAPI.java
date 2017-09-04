package br.com.airport.model;

import br.com.airport.model.response.ResponsePeople;
import br.com.airport.model.response.ResponsePlanet;
import br.com.airport.model.response.ResponseVehicles;

public enum PathsAPI {
	
	FIND_PEOPLE("https://swapi.co/api/people/", ResponsePeople.class),
	FIND_PLANET("https://swapi.co/api/planets", ResponsePlanet.class),
	FIND_VEHICLES("https://swapi.co/api/vehicles", ResponseVehicles.class);
	
	private PathsAPI(String url,  Class<?>classResponse) {
		this.url = url;
		this.classResponse = classResponse;
	}

	private String url;
	private Class<?> classResponse;

	public String getUrl() {
		return url;
	}

	public Class<?> getClassResponse() {
		return classResponse;
	}
}
