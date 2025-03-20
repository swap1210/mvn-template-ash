package com.ashwija.mvn;

import com.ashwija.mvn.driver.MainDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class MavenTemplateMain {
    public static void main(String[] args) {
        // Load properties file
        InputStream input = MavenTemplateMain.class.getClassLoader()
                .getResourceAsStream("secrets.yaml");

        if (input == null) {
            System.out.println("Unable to find application.properties");
            return;
        }
        // Parse YAML
        Yaml yaml = new Yaml();
        Map<String, Map<String, String>> config = yaml.load(input);
        Map<String, String> dbConfig = config.get("db");

        // Get properties
        String url = dbConfig.get("url");
        String username = dbConfig.get("username");
        String password = dbConfig.get("password");
        DatabaseConnectionTest.test(url, username, password);
        MainDriver mainDriver = new MainDriver();
        mainDriver.execute();
    }
}
