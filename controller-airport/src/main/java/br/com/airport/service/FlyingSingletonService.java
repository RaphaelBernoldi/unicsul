package br.com.airport.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.com.airport.model.Flying;
import br.com.airport.model.result.People;
import br.com.airport.model.result.Planet;
import br.com.airport.model.result.Vehicle;

public class FlyingSingletonService {

	private static FlyingSingletonService instance;
	private List<Flying> flyings;
	private ConsumerSwapiService consumerSwapiService;
	private FlyingSingletonService() {}
	private static Logger logger = Logger.getLogger(FlyingSingletonService.class.getName());


	public static FlyingSingletonService getInstance() {
		logger.info("getInstance");
		if(instance == null){
			instance = new FlyingSingletonService();
		}
		return instance;
	}

	public List<Flying> getFlyings() {
		logger.info("getFlyings");
		if(flyings == null){
			flyings = new ArrayList<>();
		}
		logger.info("getFlyings contem " + flyings.size() + "elements");
		return flyings;
	}

	public void setFlyings(List<Flying> flyings) {
		this.flyings = flyings;
	}

	public void createFlying(Vehicle vehicle, Planet planet, List<People>peoples) throws IllegalArgumentException{
		logger.info("createFlying");

		validate(vehicle, planet, peoples);
		Flying flying = new Flying();
		flying.setPlanetDestiny(planet);
		flying.setVehicle(vehicle);
		flying.getPeoples().addAll(peoples);
		getFlyings().add(flying);
	}
	
	private void validate(Vehicle vehicle, Planet planet, List<People>peoples) throws IllegalArgumentException{
		logger.info("validate");

		if(vehicle == null || planet == null || peoples.isEmpty()){
			throw new IllegalArgumentException("Data invalid");
		}
		
		if(peoples.size() > Integer.valueOf(vehicle.getPassengers())){
			throw new IllegalArgumentException("The number of passengers exceeded a limit");
		}
		
		if(!getFlyings().isEmpty() && 
			getFlyings().get(getFlyings().size() - 1).getPlanetDestiny().getName().equals(planet.getName())){
			throw new IllegalArgumentException("The planet is equal a last flying");
		}
	}

	public ConsumerSwapiService getConsumerSwapiService() {
		logger.info("getConsumerSwapiService");
		if(consumerSwapiService == null){
			consumerSwapiService = new ConsumerSwapiServiceImpl();
		}
		return consumerSwapiService;
	}

	public void setConsumerSwapiService(ConsumerSwapiService consumerSwapiService) {
		this.consumerSwapiService = consumerSwapiService;
	}
	
	
	
}
