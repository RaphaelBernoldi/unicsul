package br.com.airport.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public abstract class HttpClientUtil {
	private static Logger logger = Logger.getLogger(HttpClientUtil.class.getName());


	public static String doGet(String url) throws ClientProtocolException, IOException{
		logger.info("doGet " + url);
		HttpGet request = new HttpGet(url);
		HttpClient http = HttpClientBuilder.create().build();
		HttpResponse response = http.execute(request);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));		
		
		StringBuilder result = new StringBuilder();
		String line = "";
		while ((line = buffer.readLine()) != null) {
			result.append(line);
		}
		//logger.info("Response: " + result.toString());

		return result.toString();
	}
}
