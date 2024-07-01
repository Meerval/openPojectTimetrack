package com.openproject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.openproject.config.Property;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CalendarPage {
    private final SelenideElement logTimeButton = $("button[class='button te-calendar--create-button']");

    private final SelenideElement modalWindow = $("div[class*='spot-modal_allow-overflow']");
    private final SelenideElement spentOnField = modalWindow.find("#wp-new-inline-edit--field-spentOn");
    private final SelenideElement hoursField = modalWindow.find("#wp-new-inline-edit--field-hours");
    private final SelenideElement projectCodeField = modalWindow.find("#wp-new-inline-edit--field-workPackage .ng-input input");
    private final SelenideElement projectCodeOption = $(".op-autocompleter--wp-id");
    private final SelenideElement workActivityFiled = modalWindow.find("#wp-new-inline-edit--field-activity .ng-input input");
    private final SelenideElement workCommentField = modalWindow.find("#wp-new-inline-edit--field-comment");
    private final SelenideElement createButton = modalWindow.find("[title='Save']");

    private void fillDay(@NotNull String date) {
        logTimeButton.shouldHave(Condition.visible, Duration.ofMinutes(3)).click();

        spentOnField.clear();
        spentOnField.sendKeys(date);

        hoursField.clear();
        hoursField.sendKeys(Property.hours.getProperty());

        String projectCode = Property.work_projectCode.getProperty();
        projectCodeField.sendKeys(projectCode);
        projectCodeOption.shouldHave(Condition.text("#" + projectCode));
        projectCodeField.pressEnter();

        workActivityFiled.sendKeys(Property.work_activity.getProperty());
        workActivityFiled.pressEnter();

        workCommentField.clear();
        workCommentField.sendKeys(Property.work_comment.getProperty());

        createButton.click();
    }

    public void fillDays(@NotNull List<String> dates) {
        for (String date : dates) {
            fillDay(date);
        }
    }
}
