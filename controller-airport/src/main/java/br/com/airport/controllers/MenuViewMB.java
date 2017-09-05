package br.com.airport.controllers;

import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;

import br.com.airport.model.PathPages;

@ManagedBean
public class MenuViewMB {

	private Logger logger = Logger.getLogger(MenuViewMB.class.getName());

	public String homePage(){
		logger.info("homePage");
		return PathPages
				.HOME_PAGE
				.getPath();
	}
	public String viewCreate(){
		logger.info("viewCreate");

		return PathPages
				.CREATE_PLAN
				.getPath();
	}
	
	public String listPlan(){
		logger.info("listPlan");

		return PathPages
				.LIST_PLAN
				.getPath();
	}
}
