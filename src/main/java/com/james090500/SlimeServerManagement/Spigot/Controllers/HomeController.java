package com.james090500.SlimeServerManagement.Spigot.Controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.james090500.SlimeServerManagement.Spigot.Model.HomeModel;

import net.minecraft.server.v1_13_R2.MinecraftServer;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HomeController {
	
	@Path("/ping")
	@GET
	public String getPing() {
		JsonObject responseJson = new JsonObject();			
		String motd = Bukkit.getServer().getMotd();
		String playersOnline = Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers();
		int tps = MinecraftServer.TPS;
				
		responseJson.addProperty("success", true);
		responseJson.addProperty("motd", motd);
		responseJson.addProperty("playersOnline", playersOnline);
		responseJson.addProperty("tps", tps);
		responseJson.addProperty("version", Bukkit.getName() + " " + Bukkit.getVersion());
		responseJson.addProperty("totalEconomy", HomeModel.getTotalEconomy());
		
		return responseJson.toString();
	}
	
	@Path("/players")
	@GET	
	public String getPlayers() {
		JsonObject responseJson = new JsonObject();
		JsonArray onlinePlayers = new JsonArray();
		JsonObject currentPlayer;
		
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			currentPlayer = new JsonObject();
			currentPlayer.addProperty("uuid", p.getUniqueId().toString());
			currentPlayer.addProperty("username", p.getName());
			onlinePlayers.add(currentPlayer);
		}
		
		responseJson.addProperty("success", true);
		responseJson.add("players", onlinePlayers.getAsJsonArray());
		return responseJson.toString();
	}
	
	@Path("/console")
	@GET
	public String getConsole() {
		return "to do";
	}
}