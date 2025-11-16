package com.testinium.And.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties classpath'te bulunamadı!");
            }

            // UTF-8 ile yükle
            properties.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("config.properties yüklenirken hata oluştu!", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("config.properties içinde '" + key + "' key'i bulunamadı!");
        }
        return value;
    }

    public static double getDouble(String key) {
        return Double.parseDouble(get(key));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
