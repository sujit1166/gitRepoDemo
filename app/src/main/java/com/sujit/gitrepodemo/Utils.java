package com.sujit.gitrepodemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.sujit.gitrepodemo.AppConstants.DATE_TIME_FORMAT;

public class Utils {

    public static String getDiaplayDate(String dateString) {

        try {
            SimpleDateFormat format1 = new SimpleDateFormat(DATE_TIME_FORMAT);
            Date date = format1.parse(dateString);
            DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
            return dateFormat.format(date);
        } catch (Exception e) {
            return "";
        }
    }
}