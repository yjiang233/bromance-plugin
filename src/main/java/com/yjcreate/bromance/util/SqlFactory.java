package com.yjcreate.bromance.util;

import com.yjcreate.bromance.config.ConfigManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author YJiang
 * @description The Mysql Connector
 * @date 2023/8/1 23:47
 */
public class SqlFactory {

    private static final Logger LOGGER = LogManager.getLogManager().getLogger("SqlFactory");

    private static String USERNAME = ConfigManager.getInstance().getConfig().getString("database.username");
    private static String PASSWORD = ConfigManager.getInstance().getConfig().getString("database.password");
    private static String URL = ConfigManager.getInstance().getConfig().getString("database.url");

    private static String DATABASE = ConfigManager.getInstance().getConfig().getString("database.table");

    public static Connection getConnect() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://" + URL + "/" + DATABASE, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.warning("Can not connect mysql, cased by :" + e.getMessage());
            return null;
        }
    }
}
