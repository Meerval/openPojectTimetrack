package com.iiiitech.openproject.utils;

import com.iiiitech.openproject.config.Property;
import org.jetbrains.annotations.NotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateUtils {

    private static final Boolean isOnlyWorkDays = true;

    public static List<String> getDatesFromInterval() {
        LocalDate firsDate = getLocalDate(Property.date_firstDay.getProperty());
        LocalDate lastDate = getLocalDate(Property.date_lastDay.getProperty());
        long numOfDaysBetween = ChronoUnit.DAYS.between(firsDate, lastDate) + 1;
        Predicate<LocalDate> predicate = isOnlyWorkDays
                ? date -> !date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                : date -> true;
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(firsDate::plusDays)
                .filter(predicate)
                .map(DateUtils::getStringDate)
                .collect(Collectors.toList());
    }

    private static LocalDate getLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @NotNull
    public static String getStringDate(@NotNull LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
