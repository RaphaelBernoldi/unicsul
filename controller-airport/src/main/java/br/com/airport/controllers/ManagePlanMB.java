package br.com.airport.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.airport.model.Flying;
import br.com.airport.model.PathsAPI;
import br.com.airport.model.response.ResponsePeople;
import br.com.airport.model.response.ResponsePlanet;
import br.com.airport.model.response.ResponseVehicles;
import br.com.airport.model.result.People;
import br.com.airport.model.result.Planet;
import br.com.airport.model.result.Vehicle;
import br.com.airport.service.ConsumerSwapiService;
import br.com.airport.service.ConsumerSwapiServiceImpl;
import br.com.airport.service.FlyingSingletonService;

@ManagedBean
public class ManagePlanMB {
	
	private String nameVehicle;
	private Vehicle vehicleSelected;
	private List<Vehicle>vehicles;
	
	private List<People>peoples;
	private List<People>crews;
	
	private String namePlanet;
	private List<Planet>planets;
	private Planet planetSelected;
	
	private List<Flying>flyings;
	
	private ConsumerSwapiService consumerSwapiService;
	
	@PostConstruct
	public void init(){
		consumerSwapiService = new ConsumerSwapiServiceImpl();
	}
	
	public void createFlying(){
		try{
			System.out.println("Salvando");

			FlyingSingletonService
				.getInstance()
				.createFlying(nameVehicle, nameVehicle, crews);
			
			addMessageErro("Salvo com sucesso");
		}catch (IllegalArgumentException e) {
			addMessageErro(e.getMessage());
		}
	}
	public void addMessageErro(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public List<Vehicle> getVehicles() {
		if(vehicles == null){
			ResponseVehicles response = (ResponseVehicles) consumerSwapiService.find(PathsAPI.FIND_VEHICLES);
			vehicles = response.getResults();
		}
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle getVehicleSelected() {
		return vehicleSelected;
	}

	public void setVehicleSelected(Vehicle vehicleSelected) {
		this.vehicleSelected = vehicleSelected;
	}

	public List<People> getPeoples() {
		if(peoples == null){
		  ResponsePeople response =	(ResponsePeople) consumerSwapiService.find(PathsAPI.FIND_PEOPLE);
		  peoples = response.getResults();
		}
		return peoples;
	}

	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}

	public List<People> getCrews() {
		return crews;
	}

	public void setCrews(List<People> crews) {
		this.crews = crews;
	}

	public List<Planet> getPlanets() {
		if(planets == null){
			 ResponsePlanet response =	(ResponsePlanet) consumerSwapiService.find(PathsAPI.FIND_PLANET);
			 planets = response.getResults();
		}
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	public Planet getPlanetSelected() {
		return planetSelected;
	}

	public void setPlanetSelected(Planet planetSelected) {
		this.planetSelected = planetSelected;
	}

	public List<Flying> getFlyings() {
		if(flyings == null){
			flyings = FlyingSingletonService
			.getInstance()
			.getFlyings();
		}
		return flyings;
	}

	public void setFlyings(List<Flying> flyings) {
		this.flyings = flyings;
	}

	public String getNameVehicle() {
		return nameVehicle;
	}

	public void setNameVehicle(String nameVehicle) {
		this.nameVehicle = nameVehicle;
	}

	public String getNamePlanet() {
		return namePlanet;
	}

	public void setNamePlanet(String namePlanet) {
		this.namePlanet = namePlanet;
	}
}
