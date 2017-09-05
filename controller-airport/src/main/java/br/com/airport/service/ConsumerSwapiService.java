package br.com.airport.service;

import br.com.airport.model.PathsAPI;
import br.com.airport.model.response.ResponseConsumer;

public interface ConsumerSwapiService {
	
	ResponseConsumer find(PathsAPI path);
	

}
