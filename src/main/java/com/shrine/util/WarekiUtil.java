package com.shrine.util;

import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class WarekiUtil {

    private WarekiUtil() {
    }

    public static String toWareki(LocalDate date) {
        if (date == null) {
            return "";
        }

        JapaneseDate japaneseDate = JapaneseDate.from(date);

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("Gy年M月d日")
                .withLocale(Locale.JAPAN);

        return formatter.format(japaneseDate);
    }
}