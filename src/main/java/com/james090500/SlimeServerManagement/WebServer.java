package com.james090500.SlimeServerManagement;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.james090500.SlimeServerManagement.Spigot.Controllers.HomeController;
import com.james090500.SlimeServerManagement.Spigot.Controllers.PlayerController;

public class WebServer {

    public static void startServer(String host, int port) {
    	
    	try {
	        URI baseUri = UriBuilder.fromUri("http://" + host).port(port).build();
    		ResourceConfig config = new ResourceConfig(
    				HomeController.class,
    				PlayerController.class
			);
    		
	        Server server = JettyHttpContainerFactory.createServer(baseUri, config);	       
	        server.start();	        
    		    		
	        System.out.println(String.format("\nServer Running on: http://%s:%s\n", host, port));
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
}
