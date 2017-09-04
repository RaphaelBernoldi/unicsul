package br.com.airport.model.response;

import java.util.List;

import br.com.airport.model.result.People;

public class ResponsePeople extends ResponseConsumer {

	private List<People>results;

	public List<People> getResults() {
		return results;
	}

	public void setResults(List<People> results) {
		this.results = results;
	}
	
}
