package com.james090500.SlimeServerManagement.Controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.server.v1_13_R2.MinecraftServer;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HomeController {
	
	@Path("/ping")
	@GET
	public String ping() {
		JsonObject responseJson = new JsonObject();			
		String motd = Bukkit.getServer().getMotd();
		String playersOnline = Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers();
		int tps = MinecraftServer.TPS;
				
		responseJson.addProperty("success", true);
		responseJson.addProperty("motd", motd);
		responseJson.addProperty("playersOnline", playersOnline);
		responseJson.addProperty("tps", tps);
		
		return responseJson.toString();
	}
	
	@Path("/players")
	@GET	
	public String players() {
		JsonObject responseJson = new JsonObject();
		JsonArray onlinePlayers = new JsonArray();
		
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			onlinePlayers.add(p.getUniqueId().toString().replaceAll("-", ""));
		}
		
		responseJson.addProperty("success", true);
		responseJson.add("players", onlinePlayers.getAsJsonArray());
		return responseJson.toString();
	}
}