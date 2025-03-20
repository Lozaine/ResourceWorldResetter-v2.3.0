package com.lozaine.ResourceWorldResetter.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class LogUtil {
    private static File logFile;

    public static void init(JavaPlugin plugin) {
        File logDir = new File(plugin.getDataFolder(), "logs");
        if (!logDir.exists()) logDir.mkdirs();

        logFile = new File(logDir, "resource-reset.log");
    }

    public static void log(Logger logger, String message, Level level) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            String logEntry = "[" + level + "] " + message + "\n";
            writer.write(logEntry);
            logger.log(level, message);
        } catch (IOException e) {
            logger.severe("Failed to write to log file: " + e.getMessage());
        }
    }
}