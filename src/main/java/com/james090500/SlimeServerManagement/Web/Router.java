package com.james090500.SlimeServerManagement.Web;

public class Router {	
	
	public static void initialiseRoutes() {
		RouteMaster route = RouteMaster.INSTANCE;
				
		route.setRouteGet("/", "HomeController@index");
	}
	
}
