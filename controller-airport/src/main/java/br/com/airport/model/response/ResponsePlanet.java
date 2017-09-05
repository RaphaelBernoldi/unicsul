package br.com.airport.model.response;

import java.util.List;

import br.com.airport.model.result.Planet;

public class ResponsePlanet extends ResponseConsumer {

	private List<Planet>results;

	public List<Planet> getResults() {
		return results;
	}

	public void setResults(List<Planet> results) {
		this.results = results;
	}
}
