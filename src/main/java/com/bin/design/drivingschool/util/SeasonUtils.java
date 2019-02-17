package com.bin.design.drivingschool.util;


import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 季度工具类
 *
 *
 *
 */
public class SeasonUtils {

    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static String formatDate(Date date, String pattern) {
        String strDate = null;
        try {
            if (StringUtils.isBlank(pattern)) {
                pattern = YYYYMMDD;
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            strDate = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }

    /**
     * 获取季度开始结束日期
     *
     * @param season 1:第一季度 ,2:第二季度,3:第三季度 ,4:第四季度
     */
    public static Date[] getSeasonDate(int season) {
        Date[] dates = new Date[2];
        Calendar calendar = new GregorianCalendar();
        switch (season) {
            case 0:
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
                calendar.set(Calendar.DAY_OF_MONTH,1);
                dates[0] = calendar.getTime();
                calendar.set(Calendar.MONTH, Calendar.DECEMBER);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                dates[1] = calendar.getTime();
                break;
            case 1:
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                dates[0] = calendar.getTime();
                calendar.set(Calendar.MONTH, Calendar.MARCH);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                dates[1] = calendar.getTime();
                break;
            case 2:
                calendar.set(Calendar.MONTH, Calendar.APRIL);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                dates[0] = calendar.getTime();
                calendar.set(Calendar.MONTH, Calendar.JUNE);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                dates[1] = calendar.getTime();
                break;
            case 3:
                calendar.set(Calendar.MONTH, Calendar.JULY);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                dates[0] = calendar.getTime();
                calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                dates[1] = calendar.getTime();
                break;
            case 4:
                calendar.set(Calendar.MONTH, Calendar.OCTOBER);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                dates[0] = calendar.getTime();
                calendar.set(Calendar.MONTH, Calendar.DECEMBER);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                dates[1] = calendar.getTime();
                break;
            default:
                break;
        }
        return dates;
    }

    /**
     * 获取季度开始结束日期
     *
     * @param season  1:第一季度 ,2:第二季度,3:第三季度 ,4:第四季度
     * @param pattern 格式化日期格式
     */
    public static String[] getSeasonCharDate(int season, String pattern) {
        Date[] dates = getSeasonDate(season);
        String[] charDate = new String[2];
        if (dates != null && dates.length >= 2) {
            if (dates[0] != null)
                charDate[0] = formatDate(dates[0], pattern);
            if (dates[1] != null)
                charDate[1] = formatDate(dates[1], pattern);
        }
        return charDate;
    }

    public static void main(String[] args) {
        System.out.println("全年: " + getSeasonCharDate(0, null)[0] + "--" + getSeasonCharDate(0, null)[1]);
        System.out.println(getSeasonCharDate(1, null)[0] + "--" + getSeasonCharDate(1, null)[1]);
        System.out.println(getSeasonCharDate(2, null)[0] + "--" + getSeasonCharDate(2, null)[1]);
        System.out.println(getSeasonCharDate(3, null)[0] + "--" + getSeasonCharDate(3, null)[1]);
        System.out.println(getSeasonCharDate(4, null)[0] + "--" + getSeasonCharDate(4, null)[1]);
    }

}
