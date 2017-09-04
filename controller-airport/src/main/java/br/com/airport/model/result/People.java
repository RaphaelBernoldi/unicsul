package br.com.airport.model.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = 
						{"height",
						 "mass",
						 "hair_color",
						 "skin_color",
						 "eye_color",
						 "birth_year",
						 "homeworld",
						 "films",
						 "species",
						 "vehicles",
						 "starships",
						 "created",
						 "edited",
						 "url"})
public class People extends Result  {

	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
