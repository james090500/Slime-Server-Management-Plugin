package com.james090500.SlimeServerManagement;

import org.bukkit.plugin.java.JavaPlugin;

public class MainSpigot extends JavaPlugin
{
	@Override
    public void onEnable() {
		//Save Config
		saveDefaultConfig();
				
    	WebServer.startServer(getConfig().getString("host"), getConfig().getInt("port"));
    }
    

}
