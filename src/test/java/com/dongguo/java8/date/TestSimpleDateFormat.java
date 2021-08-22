package com.dongguo.java8.date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;


/**
 * @author Dongguo
 * @date 2021/8/15 0015-13:38
 * @description:java8时间格式化方式
 */
public class TestSimpleDateFormat {
    public static void main(String[] args) throws Exception {
        //java8 时间格式化方式
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20210816",dtf);
            }

        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results =new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //模拟并发SimpleDateFormat
            results.add(pool.submit(task));
        }
        for (Future<LocalDate> future:results) {
            System.out.println(future.get());
        }
    }
}