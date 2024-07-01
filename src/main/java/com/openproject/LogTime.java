package com.openproject;

import com.openproject.config.BrowserConfiguration;
import com.openproject.pages.CalendarPage;
import com.openproject.pages.LoginPage;

import static com.openproject.utils.DateUtils.getDatesFromInterval;

public class LogTime {

    private static final LoginPage loginPage = new LoginPage();
    private static final CalendarPage calendarPage = new CalendarPage();


    public static void main(String[] args) {
        BrowserConfiguration.initWebDriver();

        // If you have to write un authentication code, you should input it and click "Sign in" by yourself in 3 minutes
        loginPage.login();
        calendarPage.fillDays(getDatesFromInterval());
    }
}