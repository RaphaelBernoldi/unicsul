package br.com.airport.convert;

import java.util.List;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.airport.model.PathsAPI;
import br.com.airport.model.response.ResponsePlanet;
import br.com.airport.model.result.Planet;
import br.com.airport.service.ConsumerSwapiService;
import br.com.airport.service.ConsumerSwapiServiceImpl;

@FacesConverter(value = "converterPlanet")
public class ConverterPlanet implements Converter {
	
	private List<Planet>planets;
	private Logger logger = Logger.getLogger(ConverterPlanet.class.getName());

	public ConverterPlanet() {
		logger.info("init");
		ConsumerSwapiService consumerSwapiService = new ConsumerSwapiServiceImpl();
		ResponsePlanet response = (ResponsePlanet) consumerSwapiService.find(PathsAPI.FIND_PLANET);
		planets = response.getResults();
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		logger.info("ConverterPlanet.getAsObject " + arg2);
		for(Planet p: planets){
			if(p.getName().equals(arg2)){
				return p;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return null;
	}

}
