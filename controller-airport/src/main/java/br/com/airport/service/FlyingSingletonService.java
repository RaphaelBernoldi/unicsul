package br.com.airport.service;

import java.util.ArrayList;
import java.util.List;

import br.com.airport.model.Flying;
import br.com.airport.model.PathsAPI;
import br.com.airport.model.response.ResponsePlanet;
import br.com.airport.model.response.ResponseVehicles;
import br.com.airport.model.result.People;
import br.com.airport.model.result.Planet;
import br.com.airport.model.result.Vehicle;

public class FlyingSingletonService {

	private static FlyingSingletonService instance;
	private List<Flying> flyings;
	private ConsumerSwapiService consumerSwapiService;
	private FlyingSingletonService() {}

	public static FlyingSingletonService getInstance() {
		if(instance == null){
			instance = new FlyingSingletonService();
		}
		return instance;
	}

	public List<Flying> getFlyings() {
		if(flyings == null){
			flyings = new ArrayList<>();
		}
		return flyings;
	}

	public void setFlyings(List<Flying> flyings) {
		this.flyings = flyings;
	}

	public void createFlying(String vehicleName, String planetName, List<People>peoples) throws IllegalArgumentException{
		if(vehicleName == null || vehicleName == null){
			throw new IllegalArgumentException("Data invalid");
		}
		Vehicle vehicle = null;
		Planet planet = null;
		ResponseVehicles responseVehicles = (ResponseVehicles) getConsumerSwapiService().find(PathsAPI.FIND_VEHICLES);	
		ResponsePlanet responsePlanet = (ResponsePlanet) getConsumerSwapiService().find(PathsAPI.FIND_PLANET);	
				
		for (Vehicle v: responseVehicles.getResults()) {
			if(vehicleName.equals(v.getName())){
				vehicle = v;
			}
		}
		for (Planet p: responsePlanet.getResults()) {
			if(planetName.equals(p.getName())){
				planet = p;
			}
		}
		validate(vehicle, planet, peoples);
		Flying flying = new Flying();
		flying.setPlanetDestiny(planet);
		flying.setVehicle(vehicle);
		flying.getPeoples().addAll(peoples);
		getFlyings().add(flying);
	}
	
	private void validate(Vehicle vehicle, Planet planet, List<People>peoples) throws IllegalArgumentException{
		if(vehicle == null || planet == null || peoples.isEmpty()){
			throw new IllegalArgumentException("Data invalid");

		}
		if(peoples.size() > Integer.valueOf(vehicle.getPassengers())){
			throw new IllegalArgumentException("The number of passengers exceeded a limit");
		}
		if(!getFlyings().isEmpty() && 
			getFlyings().get(getFlyings().size() - 1).getPlanetDestiny().getName().equals(planet.getName())){
			throw new IllegalArgumentException("The planet not equal a last flying");
		}
	}

	public ConsumerSwapiService getConsumerSwapiService() {
		if(consumerSwapiService == null){
			consumerSwapiService = new ConsumerSwapiServiceImpl();
		}
		return consumerSwapiService;
	}

	public void setConsumerSwapiService(ConsumerSwapiService consumerSwapiService) {
		this.consumerSwapiService = consumerSwapiService;
	}
	
	
	
}
