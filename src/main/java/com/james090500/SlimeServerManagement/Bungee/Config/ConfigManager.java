package com.james090500.SlimeServerManagement.Bungee.Config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class ConfigManager {

	public static Configuration getConfig() {
		try {
		Configuration fc = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
		return fc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveConfig() {
		if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        File file = new File(getDataFolder(), "config.yml");

     
        if (!file.exists()) {
            try (InputStream in = ConfigManager.class.getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static File getDataFolder() {
		return new File(ProxyServer.getInstance().getPluginsFolder() + "SlimeServerManagement");
	}
	
}
