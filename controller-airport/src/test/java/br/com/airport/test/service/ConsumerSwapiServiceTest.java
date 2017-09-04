package br.com.airport.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.airport.model.PathsAPI;
import br.com.airport.model.response.ResponseConsumer;
import br.com.airport.service.ConsumerSwapiService;
import br.com.airport.service.ConsumerSwapiServiceImpl;

@RunWith(JUnit4.class)
public class ConsumerSwapiServiceTest {

	@Test
	public void testFindPeopleNotNull(){
		ConsumerSwapiService service = new ConsumerSwapiServiceImpl();
		ResponseConsumer response = service.find(PathsAPI.FIND_PEOPLE);
		Assert.assertTrue(response != null);
	}
	
	@Test
	public void testFindPlanetNotNull(){
		ConsumerSwapiService service = new ConsumerSwapiServiceImpl();
		ResponseConsumer response = service.find(PathsAPI.FIND_PLANET);
		Assert.assertTrue(response != null);
	}
	
	@Test
	public void testFindVehiclesNotNull(){
		ConsumerSwapiService service = new ConsumerSwapiServiceImpl();
		ResponseConsumer response = service.find(PathsAPI.FIND_VEHICLES);
		Assert.assertTrue(response != null);
	}
	
	@Test
	public void testFindPeople(){
		ConsumerSwapiService service = new ConsumerSwapiServiceImpl();
		ResponseConsumer response = service.find(PathsAPI.FIND_PEOPLE);
		Assert.assertTrue(response.getCount() > 0);
	}
	
	@Test
	public void testFindPlanet(){
		ConsumerSwapiService service = new ConsumerSwapiServiceImpl();
		ResponseConsumer response = service.find(PathsAPI.FIND_PLANET);
		Assert.assertTrue(response.getCount() > 0);
	}
	
	@Test
	public void testFindVehicles(){
		ConsumerSwapiService service = new ConsumerSwapiServiceImpl();
		ResponseConsumer response = service.find(PathsAPI.FIND_VEHICLES);
		Assert.assertTrue(response.getCount() > 0);
	}
}
