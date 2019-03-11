package com.james090500.SlimeServerManagement.Web;

import java.util.HashMap;
import java.util.Map;

public class RouteMaster {
	
	public static final RouteMaster INSTANCE = new RouteMaster();
	
	private Map<String, String> GET_ROUTES = new HashMap<String, String>();
	private Map<String, String> POST_ROUTES = new HashMap<String, String>();
	
	public void setRouteGet(String route, String controller) {
		GET_ROUTES.put(route, controller);
	}
	
	public void setRoutePost(String route, String controller) {
		POST_ROUTES.put(route, controller);
	}
	
	public Map<String, String> getRoutesGet() {
		return GET_ROUTES;
	}
	
	public Map<String, String> getRoutesPost() {
		return POST_ROUTES;
	}
}
