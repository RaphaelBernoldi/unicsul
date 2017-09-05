package br.com.airport.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.airport.model.PathsAPI;
import br.com.airport.model.response.ResponsePeople;
import br.com.airport.model.result.People;
import br.com.airport.model.result.Planet;
import br.com.airport.model.result.Vehicle;
import br.com.airport.service.ConsumerSwapiService;
import br.com.airport.service.ConsumerSwapiServiceImpl;
import br.com.airport.service.FlyingSingletonService;

@RunWith(JUnit4.class)
public class FlyingServiceSingletonTest {

	private ConsumerSwapiService consumerSwapiService;
	
	public FlyingServiceSingletonTest(){
		consumerSwapiService = new ConsumerSwapiServiceImpl();
	}
	
	@Test
	public void createFlyingCorrectTest(){
		FlyingSingletonService instance = FlyingSingletonService.getInstance();
		
		Vehicle vehicle = newVehicle();
		
		Planet planet = newPlanet();
		
		List<People>peoples = new ArrayList<>();
		People people = newPeople();
		peoples.add(people);
		instance.createFlying(vehicle, planet, peoples);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createFlyingExcedPeopleTest(){
		FlyingSingletonService instance = FlyingSingletonService.getInstance();
		
		Vehicle vehicle = newVehicle();
		
		Planet planet = newPlanet();
		
		ResponsePeople response = (ResponsePeople) consumerSwapiService.find(PathsAPI.FIND_PEOPLE);
		List<People>peoples = response.getResults();
		instance.createFlying(vehicle, planet, peoples);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createFlyingDataNullTest(){
		FlyingSingletonService instance = FlyingSingletonService.getInstance();
		
		instance.createFlying(null, null, new ArrayList<>());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createFlyingPlanetRepeatTest(){
		FlyingSingletonService instance = FlyingSingletonService.getInstance();
		
		Vehicle vehicle = newVehicle();
		
		Planet planet = newPlanet();
		
		People people = newPeople();
		List<People>peoples = new ArrayList<>();
		peoples.add(people);
		
		instance.createFlying(vehicle, planet , peoples);
		instance.createFlying(vehicle, planet, peoples);
	}
	
	@Test
	public void createFlyingListTest(){
		FlyingSingletonService instance = FlyingSingletonService.getInstance();
		
		Vehicle vehicle = newVehicle();
		
		Planet planet = newPlanet();
		
		List<People>peoples = new ArrayList<>();
		People people = newPeople();
		peoples.add(people);
		planet.setName("Terra");
		instance.createFlying(vehicle, planet, peoples);
		Assert.assertTrue(instance.getFlyings().size() > 0);
		instance.getFlyings();
	
	}
	
	
	
	private People newPeople(){
		People people = new People();
		people.setName("Luke Skywalker");
		people.setGender("male");
		return people;
	}
	private Planet newPlanet(){
		Planet planet = new Planet();
		planet.setName("Tatooine");
		planet.setDiameter("10465");
		planet.setClimate("arid");
		planet.setTerrain("desert");
		planet.setPopulation("20000");
		return planet;
	}
	
	private Vehicle newVehicle(){
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Millenium Facon");
		vehicle.setModel("YT-1300 freighter");
		vehicle.setPassengers("1");
		return vehicle;
	}
}
