package com.openproject.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public enum Property {
    url_template("url.template"),
    isVacation("is_vacation"),
    hours("hours"),
    work_projectCode("work.project_code"),
    work_activity("work.activity"),
    work_comment("work.comment"),
    date_firstDay("date.first_day"),
    date_lastDay("date.last_day");

    private final String propertyName;

    Property(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getProperty() {
        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/config.properties"))) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(propertyName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propertyName;
    }
}

