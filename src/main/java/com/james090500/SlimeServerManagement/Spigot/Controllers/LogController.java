package com.james090500.SlimeServerManagement.Spigot.Controllers;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.atmosphere.annotation.Broadcast;
import org.atmosphere.annotation.Suspend;
import org.eclipse.jetty.server.Response;

@Path("/log")
@Produces("application/json")
public class LogController {
	
	@Suspend
	@GET
	public String suspend() {
		return "";
	}
	
	@Broadcast(writeEntity = false)
	@POST
	public Response broadcast(Response message) {
		System.out.println("RECIEVED");
		return message;
	}

}
