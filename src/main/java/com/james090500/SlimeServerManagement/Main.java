package com.james090500.SlimeServerManagement;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import com.james090500.SlimeServerManagement.Web.WebServer;

public class Main extends JavaPlugin
{
	
	//https://jersey.github.io seems like the way :/
    @Override
    public void onEnable() {
    	try {
			new WebServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
