package com.dongguo.java8.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dongguo
 * @date 2021/8/16 0016-8:35
 * @description:
 */
public class DateFormatThreadLocal {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }
}