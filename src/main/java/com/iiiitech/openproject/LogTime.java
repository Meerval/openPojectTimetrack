package com.iiiitech.openproject;

import com.iiiitech.openproject.config.BrowserConfiguration;
import com.iiiitech.openproject.pages.CalendarPage;
import com.iiiitech.openproject.pages.LoginPage;

import static com.iiiitech.openproject.utils.DateUtils.getDatesFromInterval;

public class LogTime {

    private static final LoginPage loginPage = new LoginPage();
    private static final CalendarPage calendarPage = new CalendarPage();


    public static void main(String[] args) {
        BrowserConfiguration.initWebDriver();

        loginPage.login();
        calendarPage.fillDays(getDatesFromInterval());
    }
}