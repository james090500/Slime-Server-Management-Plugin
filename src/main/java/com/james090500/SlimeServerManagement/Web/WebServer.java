package com.james090500.SlimeServerManagement.Web;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.james090500.SlimeServerManagement.Spigot.Controllers.HomeController;
import com.james090500.SlimeServerManagement.Spigot.Controllers.PlayerController;

public class WebServer {
		
	private static WebServer INSTANCE = new WebServer();
	private static Server server;
	
	public static WebServer getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Starts the Jetty server
	 * @param host The host to bind to
	 * @param port The port to bind to
	 */
    public void startServer(String host, int port) {
    	
    	//Disables Jetty logging due to spigot
    	System.setProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.StdErrLog");
    	System.setProperty("org.eclipse.jetty.LEVEL", "OFF");
    	
    	try {
	        URI baseUri = UriBuilder.fromUri("http://" + host).port(port).build();
    		ResourceConfig config = new ResourceConfig(
    				HomeController.class,
    				PlayerController.class
			);
    		
	        server = JettyHttpContainerFactory.createServer(baseUri, config);	       
	        server.start();	        
    		    		
	        System.out.println("#################################################");
	        System.out.println("              SlimeServerManagement              ");
	        System.out.println(String.format("Server Running on: http://%s:%s", host, port));
	        System.out.println("#################################################");	        
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * Stops the Jetty server
     */
    public void stopServer() {
    	try {
			server.stop();
		} catch (Exception e) { 
			e.printStackTrace();
		}
    }
	
}
