package com.james090500.SlimeServerManagement.Spigot.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.atmosphere.client.TrackMessageSizeInterceptor;
import org.atmosphere.config.service.AtmosphereService;
import org.atmosphere.cpr.ApplicationConfig;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.atmosphere.interceptor.AtmosphereResourceLifecycleInterceptor;

@Path("/")
@AtmosphereService(
		dispatch = true,
		interceptors = { AtmosphereResourceLifecycleInterceptor.class, TrackMessageSizeInterceptor.class },
		path="/log",
		servlet = "org.glassfish.jersey.servlet.ServletContainer")	
public class LogController {
							
    @Context
    private HttpServletRequest request;
	
    @GET
    public void configureAtmosphereResource() {
        AtmosphereResource r = (AtmosphereResource) request.getAttribute(ApplicationConfig.ATMOSPHERE_RESOURCE);

        if (r != null) {
            r.addEventListener(new AtmosphereResourceEventListenerAdapter.OnDisconnect() {
                @Override
                public void onDisconnect(AtmosphereResourceEvent event) {
                    if (event.isCancelled()) {
                        System.out.println("Browser {} unexpectedly disconnected" + event.getResource().uuid());
                    } else if (event.isClosedByClient()) {
                    	System.out.println("Browser {} closed the connection" + event.getResource().uuid());
                    }
                }
            });
        } else {
            throw new IllegalStateException();
        }
    }


    /**
     * Echo the chat message. Jackson can clearly be used here, but for simplicity we just echo what we receive.
     *
     * @param message
     */
    @GET
    public void broadcast(String message) {
        AtmosphereResource r = (AtmosphereResource) request.getAttribute(ApplicationConfig.ATMOSPHERE_RESOURCE);

        if (r != null) {
            r.getBroadcaster().broadcast(message);
        } else {
            throw new IllegalStateException();
        }
    }
}
