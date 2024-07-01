package com.openproject.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserConfiguration {

    private static final String[] chromeOptionsArguments = {"--remote-allow-origins=*"};
    private static final String url = Property.url_template.getProperty().replace("{}", System.getenv(Environment.company.name()));

    public static void initWebDriver() {
        setUpChromeOptions();
        setUpWebDriverConfiguration();
        Selenide.open("/login");
    }

    public static void setUpChromeOptions() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();

        options.addArguments(chromeOptionsArguments);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 15_000;
        Configuration.pageLoadTimeout = 15_000;
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
    }

    public static void setUpWebDriverConfiguration() {
        Configuration.baseUrl = url;
    }
}
