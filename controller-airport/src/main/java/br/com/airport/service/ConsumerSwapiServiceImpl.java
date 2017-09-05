package br.com.airport.service;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.client.ClientProtocolException;

import br.com.airport.model.PathsAPI;
import br.com.airport.model.response.ResponseConsumer;
import br.com.airport.util.ConvertJsonUtil;
import br.com.airport.util.HttpClientUtil;

public class ConsumerSwapiServiceImpl implements ConsumerSwapiService {

	private Logger logger = Logger.getLogger(ConsumerSwapiServiceImpl.class.getName());

	public ResponseConsumer find(PathsAPI path) {
		logger.info("find "+path.getUrl());
		try {
			String json = HttpClientUtil.doGet(path.getUrl());
			//logger.info(json);
			return (ResponseConsumer) ConvertJsonUtil.convertToObject(json, path.getClassResponse());
			
		} catch (ClientProtocolException e) {
			logger.info("Erro: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("find returned null.");
		return null;
	}

}
