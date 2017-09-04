package br.com.airport.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public abstract class HttpClientUtil {

	public static String doGet(String url) throws ClientProtocolException, IOException{
		HttpGet request = new HttpGet(url);
		HttpClient http = HttpClientBuilder.create().build();
		HttpResponse response = http.execute(request);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));		
		
		StringBuilder result = new StringBuilder();
		String line = "";
		while ((line = buffer.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}
}
