package me.Shadow48402.superboots;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingsManager {
	public Superboots plugin;
	public SettingsManager(Superboots plugin){
		this.plugin = plugin;
	}

	private FileConfiguration settings;
	private File sfile;

	public void setup() {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}

		sfile = new File(plugin.getDataFolder(), "settings.yml");

		if (!sfile.exists()) {
			try {
				sfile.createNewFile();
				
				settings = YamlConfiguration.loadConfiguration(sfile);
				settings.set("HealChange", 100);
				settings.save(sfile);
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create settings.yml!");
			}
		} else {
			settings = YamlConfiguration.loadConfiguration(sfile);
		}
	}

	public FileConfiguration getSettings() {
		return settings;
	}

	public void saveSettings() {
		try {
			settings.save(sfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save settings.yml!");
		}
	}

	public void reloadSettings() {
		settings = YamlConfiguration.loadConfiguration(sfile);
	}

	public PluginDescriptionFile getDesc() {
		return plugin.getDescription();
	}
}