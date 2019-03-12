package com.james090500.SlimeServerManagement;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.bukkit.plugin.java.JavaPlugin;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.james090500.SlimeServerManagement.Controllers.HomeController;

public class Main extends JavaPlugin
{
	@Override
    public void onEnable() {
    	startServer();
    }
    
    private void startServer() {
    	try {
	        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
	        ResourceConfig config = new ResourceConfig(HomeController.class);
	        Server server = JettyHttpContainerFactory.createServer(baseUri, config);
	        server.start();
	        System.out.println("\nServer Running on: http://localhost:8080\n");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
