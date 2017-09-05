package br.com.airport.model;

public enum PathPages {

	HOME_PAGE("/index.xhtml"),
	CREATE_PLAN("/pages/createPlan.xhtml"),
	LIST_PLAN("/pages/listPlan.xhtml");
	
	private PathPages(String path) {
		this.path = path;
	}
	
	private String path;

	public String getPath() {
		return path;
	}
	
	
}
