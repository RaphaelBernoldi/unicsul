package br.com.airport.model.response;

import java.util.List;

import br.com.airport.model.result.Vehicle;

public class ResponseVehicles extends ResponseConsumer {

	private List<Vehicle>results;

	public List<Vehicle> getResults() {
		return results;
	}

	public void setResults(List<Vehicle> results) {
		this.results = results;
	}
}
