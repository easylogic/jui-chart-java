package com.jennifer.ui.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

;

public class TimeUtil {

    public static Date add(Date d, Time type, int interval) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        if (type == Time.YEARS) {
            c.add(Calendar.YEAR, interval);
        } else if (type == Time.MONTHS) {
            c.add(Calendar.MONTH, interval);
        } else if (type == Time.DAYS) {
            c.add(Calendar.DATE, interval);
        } else if (type == Time.HOURS) {
            c.add(Calendar.HOUR_OF_DAY, interval);
        } else if (type == Time.MINUTES) {
            c.add(Calendar.MINUTE, interval);
        } else if (type == Time.SECONDS) {
            c.add(Calendar.SECOND, interval);
        } else if (type == Time.MILLISECONDS) {
            c.add(Calendar.MILLISECOND, interval);
        } else if (type == Time.WEEKS) {
            c.add(Calendar.DATE, interval * 7);
        }

        return c.getTime();
    }

    public static String format(Date d, String format) {
        return new SimpleDateFormat(format).format(d);
    }
}
