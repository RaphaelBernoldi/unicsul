package br.com.airport.test.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.airport.model.PathsAPI;
import br.com.airport.util.HttpClientUtil;

@RunWith(JUnit4.class)
public class HttpClientUtilTest {

	@Test
	public void testRequestFindPeople(){
		try {
			Assert.assertNotNull(HttpClientUtil.doGet(PathsAPI.FIND_PEOPLE.getUrl()));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRequestFindPlanet(){
		try {
			Assert.assertNotNull(HttpClientUtil.doGet(PathsAPI.FIND_PLANET.getUrl()));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRequestFindVehicles(){
		try {
			Assert.assertNotNull(HttpClientUtil.doGet(PathsAPI.FIND_VEHICLES.getUrl()));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
