package br.com.airport.convert;

import java.util.List;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.airport.model.PathsAPI;
import br.com.airport.model.response.ResponseVehicles;
import br.com.airport.model.result.Vehicle;
import br.com.airport.service.ConsumerSwapiService;
import br.com.airport.service.ConsumerSwapiServiceImpl;

@FacesConverter(value = "converterVehicle")
public class ConverterVehicle implements Converter {
	
	private List<Vehicle>vehicles;
	private Logger logger = Logger.getLogger(ConverterVehicle.class.getName());

	public ConverterVehicle() {
		logger.info("init");
		ConsumerSwapiService consumerSwapiService = new ConsumerSwapiServiceImpl();
		ResponseVehicles response = (ResponseVehicles) consumerSwapiService.find(PathsAPI.FIND_VEHICLES);
		vehicles = response.getResults();
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		logger.info("ConverterVehicle.getAsObject " + arg2);
		for(Vehicle v: vehicles){
			if(v.getName().equals(arg2)){
				return v;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return null;
	}

}
