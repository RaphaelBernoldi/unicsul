package br.com.airport.controllers;

import javax.faces.bean.ManagedBean;

import br.com.airport.model.PathPages;

@ManagedBean
public class MenuViewMB {

	public String homePage(){
		return PathPages
				.HOME_PAGE
				.getPath();
	}
	public String viewCreate(){
		return PathPages
				.CREATE_PLAN
				.getPath();
	}
	
	public String listPlan(){
		return PathPages
				.LIST_PLAN
				.getPath();
	}
}
