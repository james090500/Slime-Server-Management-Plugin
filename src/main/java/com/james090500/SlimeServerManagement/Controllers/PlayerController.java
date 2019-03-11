package com.james090500.SlimeServerManagement.Controllers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.gson.JsonArray;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response;
import fi.iki.elonen.NanoHTTPD.Response.Status;

public class PlayerController {
	
	public static Response index() {
		JsonArray onlinePlayers = new JsonArray(); 
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			onlinePlayers.add(p.getUniqueId().toString().replaceAll("-", ""));
		}
		Response res = NanoHTTPD.newFixedLengthResponse(Status.OK, "application/json", onlinePlayers.toString());
		return res;
	}
	
	public static Response getPlayer() {
		Response res = NanoHTTPD.newFixedLengthResponse(Status.OK, "application/json", "IT WORKS");
		return res;
	}

}
