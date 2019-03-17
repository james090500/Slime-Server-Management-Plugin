package com.james090500.SlimeServerManagement.Spigot.Model;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class HomeModel {

	public static double getTotalEconomy() {
		double totalEconomy = 0;
		
		File essentialsUserData = new File("plugins\\Essentials\\userdata");		
		File[] totalFiles = essentialsUserData.listFiles();
		if (totalFiles != null) {
			YamlConfiguration userFile;
		    for (File child : totalFiles) {
		      userFile = YamlConfiguration.loadConfiguration(child);
		      if(userFile.getString("money") != null) {
		    	  totalEconomy += Double.parseDouble(userFile.getString("money"));		    	  
		      }		      
		    }
		}
		return totalEconomy;
	}
	
}
