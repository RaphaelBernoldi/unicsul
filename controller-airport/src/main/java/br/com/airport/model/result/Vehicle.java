package br.com.airport.model.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "manufacturer", "cost_in_credits", "length", "max_atmosphering_speed", "crew", "films",
		"cargo_capacity", "consumables", "vehicle_class", "pilots", "films","created","edited", "url" })
public class Vehicle extends Result {
	
	private String model;
	private String passengers;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPassengers() {
		return passengers;
	}
	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}
}
