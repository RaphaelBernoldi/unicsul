package br.com.airport.model;

import java.util.ArrayList;
import java.util.List;

import br.com.airport.model.result.People;
import br.com.airport.model.result.Planet;
import br.com.airport.model.result.Vehicle;

public class Flying {

	private Vehicle vehicle;
	private List<People>peoples;
	private Planet planetDestiny;
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public List<People> getPeoples() {
		if(peoples == null)
			peoples = new ArrayList<>();
		return peoples;
	}
	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}
	public Planet getPlanetDestiny() {
		return planetDestiny;
	}
	public void setPlanetDestiny(Planet planetDestiny) {
		this.planetDestiny = planetDestiny;
	}
	
	
}
