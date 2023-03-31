package com.openproject.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserConfiguration {

    private static final String[] chromeOptionsArguments = {"--remote-allow-origins=*"};
    private static final String url = Property.url_template.getProperty().replace("{}", System.getenv(Environment.company.name()));

    public static void initWebDriver() {
        setUpChromeOptions();
        setUpWebDriverConfiguration();
        Selenide.open("/login");
    }

    public static void setUpChromeOptions() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments(chromeOptionsArguments);
    }

    public static void setUpWebDriverConfiguration() {
        Configuration.baseUrl = url;
    }
}
