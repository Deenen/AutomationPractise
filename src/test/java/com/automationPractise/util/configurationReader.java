package com.automationPractise.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class configurationReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream in = new FileInputStream("configuration.properties")) {
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load properties file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
