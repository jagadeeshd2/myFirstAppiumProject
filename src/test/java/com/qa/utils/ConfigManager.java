package com.qa.utils;


import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties props = new Properties();
    private static boolean isLoaded = false;

    private ConfigManager() {
        // Prevent instantiation
    }

    /** Load configuration from classpath once before tests */
    public static void loadConfig() {
        if (isLoaded) return;

        try (InputStream input = ConfigManager.class.getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("❌ config.properties not found in classpath (src/test/resources)");
            }

            props.load(input);
            isLoaded = true;
            System.out.println("✅ Config file loaded successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to load config.properties", e);
        }
    }

    /** Get a value by key (supports env var override for CI/CD) */
    public static String get(String key) {
        String envValue = System.getProperty(key);
        if (envValue != null && !envValue.isEmpty()) {
            return envValue.trim();
        }

        String value = props.getProperty(key);
        if (value == null) {
            throw new RuntimeException("❌ Config key not found: " + key);
        }
        return value.trim();
    }
}
