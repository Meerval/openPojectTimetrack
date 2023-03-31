package com.iiiitech.openproject.pages;

import com.codeborne.selenide.SelenideElement;
import com.iiiitech.openproject.config.Environment;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final SelenideElement usernameField = $("#username");
    private static final SelenideElement passwordField = $("#password");
    private static final SelenideElement loginButton = $("#login-form input[name='login']");

    public void login() {
        usernameField.sendKeys(System.getenv(Environment.login.name()));
        passwordField.sendKeys(System.getenv(Environment.password.name()));
        loginButton.click();
    }

}
