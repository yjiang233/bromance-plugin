package com.yjcreate.bromance.config;

import com.yjcreate.bromance.BromanceApplication;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * @author YJiang
 * @description The Config manager
 * @date 2023/8/1 23:50
 */
public class ConfigManager {

    private static ConfigManager INSTANCE;

    public static ConfigManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConfigManager();
        }
        return INSTANCE;
    }

    public FileConfiguration getConfig() {
        return BromanceApplication.getInstance().getConfig();
    }
}
