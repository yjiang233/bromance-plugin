package com.yjcreate.bromance;

import com.yjcreate.bromance.commands.CommandFly;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * @author YJiang
 * @description The Main
 * @date 2023/8/1 23:02
 */
public class BromanceApplication extends JavaPlugin {

    private static BromanceApplication instance;

    private final String CONFIG_FILE_NAME = "bromance.yml";

    private static File configFile;
    private static FileConfiguration config;

    public BromanceApplication() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Find config
        configFile = new File(getDataFolder(), CONFIG_FILE_NAME);
        config = YamlConfiguration.loadConfiguration(configFile);
        // If the config not exists, generate a new config file
        if (!configFile.exists()) {
            config.options().copyDefaults(true);
            saveConfig();
        }

        // Register commands
        this.getCommand("fly").setExecutor(new CommandFly());
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public static BromanceApplication getInstance() {
        return instance;
    }
}
