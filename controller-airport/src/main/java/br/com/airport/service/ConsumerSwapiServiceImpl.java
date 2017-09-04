package br.com.airport.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import br.com.airport.model.PathsAPI;
import br.com.airport.model.response.ResponseConsumer;
import br.com.airport.util.ConvertJsonUtil;
import br.com.airport.util.HttpClientUtil;

public class ConsumerSwapiServiceImpl implements ConsumerSwapiService {

	public ResponseConsumer find(PathsAPI path) {
		try {
			String json = HttpClientUtil.doGet(path.getUrl());
			return (ResponseConsumer) ConvertJsonUtil.convertToObject(json, path.getClassResponse());
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
