package com.james090500.SlimeServerManagement;

import com.james090500.SlimeServerManagement.Bungee.Config.ConfigManager;
import com.james090500.SlimeServerManagement.Web.WebServer;

import net.md_5.bungee.api.plugin.Plugin;

public class MainBungee extends Plugin {

	@Override
    public void onEnable() {	
		//Save Config
		ConfigManager.saveConfig();
		
		//Starts the server
    	WebServer.getInstance().startServer(ConfigManager.getConfig().getString("host"), ConfigManager.getConfig().getInt("port"));
    }    
	
	@Override
	public void onDisable() {
		//Stops the server
		WebServer.getInstance().stopServer();
	}
	
}
