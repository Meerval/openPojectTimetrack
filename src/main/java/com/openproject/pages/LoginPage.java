package com.openproject.pages;

import com.codeborne.selenide.SelenideElement;
import com.openproject.config.Environment;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final SelenideElement usernameField = $("#username");
    private static final SelenideElement passwordField = $("#password");
    private static final SelenideElement loginButton = $("#login-form input[name='login']");

    public void login() {
        usernameField.sendKeys(System.getenv(Environment.login.name()));
        passwordField.sendKeys(System.getenv(Environment.password.name()));

        // If you have to write un authentication code, you should input it and click "Sign in" by yourself in 3 minutes
        loginButton.click();
    }

}
