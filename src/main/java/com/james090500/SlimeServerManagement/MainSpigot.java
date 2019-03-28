package com.james090500.SlimeServerManagement;

import org.bukkit.plugin.java.JavaPlugin;

import com.james090500.SlimeServerManagement.Web.WebServer;

public class MainSpigot extends JavaPlugin
{
	@Override
    public void onEnable() {
		//Save Config
		saveDefaultConfig();
		
		//Starts the server
    	WebServer.getInstance().startServer(getConfig().getString("host"), getConfig().getInt("port"));
    }
    
	@Override
	public void onDisable() {
		//Stops the server
		WebServer.getInstance().stopServer();
	}

}
