package br.com.airport.test.util;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.airport.model.response.ResponseConsumer;
import br.com.airport.util.ConvertJsonUtil;

@RunWith(JUnit4.class)
public class ConvertJsonUtilTest {

	@Test
	public void testConvert(){
		try {
			String json = 
					"{count:10,"
					+ "next: 'http://google.com.br',"
					+ "previous: 'http://google.com.br',"
					+ "results: []"
					+ "}";
			
			ResponseConsumer responseConsumer = (ResponseConsumer) ConvertJsonUtil.convertToObject(json, ResponseConsumer.class);
			Assert.assertTrue(responseConsumer.getCount().intValue() == 10);
			Assert.assertTrue(responseConsumer.getNext().equals("http://google.com.br"));
			
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
	}
}
