package br.com.airport.util;

import java.io.IOException;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJsonUtil{

	private static Logger logger = Logger.getLogger(ConvertJsonUtil.class.getName());

	public static Object convertToObject(String json, Class<?>clazz) throws JsonParseException, JsonMappingException, IOException{
		logger.info("convertToObject");
		//logger.info("json: " + json + " to "+clazz.getName());

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, clazz);
	}
}
