package com.james090500.SlimeServerManagement.Spigot.Controllers;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.google.gson.JsonObject;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerController {
		
	@Path("/{uuid: [a-fA-F0-9-]{36}}")
	@GET
	public String getPlayer(@PathParam("uuid") String uuid) {		
		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
		if(offlinePlayer.isOnline()) {			
			Player player = (Player) offlinePlayer;
			
			JsonObject responseJson = new JsonObject();			
					
			responseJson.addProperty("success", true);			
			responseJson.addProperty("username", player.getName());
			responseJson.addProperty("uuid", player.getUniqueId().toString());
			responseJson.addProperty("online", true);
			
			JsonObject gameplayObject = new JsonObject();
			gameplayObject.addProperty("gamemode", player.getGameMode().toString());
			gameplayObject.addProperty("health", player.getHealth());
			gameplayObject.addProperty("level", player.getLevel());
			gameplayObject.addProperty("hunger", player.getFoodLevel());
			responseJson.add("gameplay", gameplayObject);
			
			JsonObject locationObject = new JsonObject();
			locationObject.addProperty("x", player.getLocation().getBlockX());
			locationObject.addProperty("y", player.getLocation().getBlockY());
			locationObject.addProperty("z", player.getLocation().getBlockZ());
			locationObject.addProperty("world", player.getLocation().getWorld().getName());
			responseJson.add("location", locationObject);			
			
			responseJson.addProperty("ip", player.getAddress().getAddress().toString().replace("/", ""));			
			
			return responseJson.toString();
		} else {
			JsonObject responseJson = new JsonObject();			
			
			responseJson.addProperty("success", true);
			responseJson.addProperty("username", offlinePlayer.getName());
			responseJson.addProperty("uuid", offlinePlayer.getUniqueId().toString());
			responseJson.addProperty("online", false);
			return responseJson.toString();
		}
	}
	
}
