 package com.james090500.SlimeServerManagement.Web;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.Status;

public class WebServer extends NanoHTTPD {
	
	/**
	 * Starts the web server on specified port
	 * @throws IOException
	 */
	public WebServer() throws IOException {
		super(8080);
		Router.initialiseRoutes();
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
	}
	
	/**
	 * 
	 */
	@Override
	public Response serve(IHTTPSession session) {	
				
		String[] routeController;

		switch(session.getMethod()) {
			case GET:
				routeController = RouteMaster.INSTANCE.getRoutesGet().get(session.getUri()).split("@");
				break;
			case POST:
				routeController = RouteMaster.INSTANCE.getRoutesPost().get(session.getUri()).split("@");
				break;
			default:
				return newFixedLengthResponse(Status.METHOD_NOT_ALLOWED, MIME_HTML, "METHOD_NOT_ALLOWED");
		}		
		
		try {
			Class<?> c = Class.forName("com.james090500.SlimeServerManagement.Controllers." + routeController[0]);
			return (Response) c.getMethod(routeController[1]).invoke(c);
		} catch(Exception e) {
			e.printStackTrace();
			return newFixedLengthResponse(Status.INTERNAL_ERROR, MIME_HTML, "INTERNAL_ERROR");
		}		
	}	
}
