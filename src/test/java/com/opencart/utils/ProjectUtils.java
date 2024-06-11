package com.opencart.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.Reporter;

public class ProjectUtils {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ProjectUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static void logf(String str, Object... arr) {
        String formattedMessage = String.format(str, arr);
        Reporter.log(formattedMessage, true);
    }
}
