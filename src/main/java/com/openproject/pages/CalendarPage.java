package com.openproject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.openproject.config.Property;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CalendarPage {
    private static final SelenideElement logTimeButton = $("button[class='button te-calendar--create-button']");

    private static final SelenideElement modalWindow = $("div[class*='op-modal_autoheight']");
    private static final SelenideElement spentOnField = modalWindow.find("#wp-new-inline-edit--field-spentOn");
    private static final SelenideElement hoursField = modalWindow.find("#wp-new-inline-edit--field-hours");
    private static final SelenideElement projectCodeField = modalWindow.find("#wp-new-inline-edit--field-workPackage .ng-input input");
    private static final SelenideElement projectCodeOption = $("[class='ng-option ng-option-marked']");
    private static final SelenideElement workActivityFiled = modalWindow.find("#wp-new-inline-edit--field-activity .ng-input input");
    private static final SelenideElement workCommentField = modalWindow.find("#wp-new-inline-edit--field-comment");
    private static final SelenideElement createButton = modalWindow.find("div[class*='op-modal_autoheight'] [title='Create']");

    private static final Boolean isVacation = Boolean.getBoolean(Property.isVacation.getProperty());

    private static final String hours = Property.hours.getProperty();
    private static final String workProjectCode = Property.work_projectCode.getProperty();
    private static final String workActivity = Property.work_activity.getProperty();
    private static final String workComment = Property.work_activity.getProperty();

    private static final String vacationProjectCode = Property.vacation_projectCode.getProperty();
    private static final String vacationActivity = Property.vacation_activity.getProperty();
    private static final String vacationComment = Property.vacation_comment.getProperty();

    private static void fillDay(@NotNull String date) {
        logTimeButton.click();

        spentOnField.clear();
        spentOnField.sendKeys(date);

        hoursField.clear();
        hoursField.sendKeys(hours);

        projectCodeField.sendKeys(isVacation ? vacationProjectCode : workProjectCode);
        projectCodeOption.shouldBe(Condition.exist);
        projectCodeField.pressEnter();

        workActivityFiled.sendKeys(isVacation ? vacationActivity : workActivity);
        workActivityFiled.pressEnter();

        workCommentField.clear();
        workCommentField.sendKeys(isVacation ? vacationComment : workComment);

        createButton.click();
    }

    public void fillDays(@NotNull List<String> dates) {
        for (String date : dates) {
            fillDay(date);
        }
    }
}
