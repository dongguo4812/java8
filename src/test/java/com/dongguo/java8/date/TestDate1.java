package com.dongguo.java8.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-13:33
 * @description:新时间与日期
 */
public class TestDate1 {
    //LocalDate, LocalTime, LocalDateTime
    @Test
    public void test1() {
        //获得当前时间
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);
        //指定时间日期
        LocalDateTime ldt2 = LocalDateTime.of(2021, 01, 01, 23, 59, 59);
        System.out.println(ldt2);
        //日期增加2年
        LocalDateTime ldt3 = ldt1.plusYears(2);
        System.out.println(ldt3);
        //日期减2个月
        LocalDateTime ldt4 = ldt1.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt1.getYear());//年
        System.out.println(ldt1.getMonthValue());//月
        System.out.println(ldt1.getDayOfMonth());//日
        System.out.println(ldt1.getHour());//时
        System.out.println(ldt1.getMinute());//分
        System.out.println(ldt1.getSecond());//秒
    }

    //Instant
    @Test
    public void test2() {
        Instant now = Instant.now();//默认获取UTC时区
        System.out.println(now);//2021-08-16T02:13:27.666Z
        OffsetDateTime odt = now.atOffset(ZoneOffset.ofHours(8));//相差8个时区，偏移8个小时
        System.out.println(odt);
        long milli = now.toEpochMilli();//获得毫秒值
        System.out.println(milli);

        Instant instant = Instant.ofEpochSecond(1000);//从Unix元年加上1000s
        System.out.println(instant);
    }

    //Duration:计算两个 时间 之间的间隔
    @Test
    public void test3() {
        Instant start = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
//        System.out.println(between.getSeconds());//秒
        System.out.println(between.toMillis());//毫秒
    }

    //Period:计算两个 日期 之间的间隔
    @Test
    public void test4() {
        LocalDate ld1 = LocalDate.of(2020, 1, 1);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

    }

    @Test
    public void test5() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);//2021-08-16T12:41:19.605
        LocalDateTime date1 = now.withDayOfMonth(10);//指定天为10号
        System.out.println(date1);//2021-08-10T12:41:19.605
        LocalDateTime date2 = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));//下周的周日
        System.out.println(date2);//2021-08-22T12:41:19.605

        //自定义下一个工作日
        LocalDateTime date3 = now.with((d) -> {
            LocalDateTime ldt = (LocalDateTime) d;
            DayOfWeek day = ldt.getDayOfWeek();
            if (day.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);//周五 增加3天
            } else if (day.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);//周六 增加2天
            } else {
                return ldt.plusDays(1);//其他 增加1天
            }
        });
        System.out.println(date3);//2021-08-17T12:41:19.605
    }

    @Test
    public void test6() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);//2021-08-16T12:57:59.397
        String date1 = now.format(dtf);
        System.out.println(date1);//2021-08-16
        System.out.println("-----------------------");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH::mm::ss");
        String date2 = now.format(dtf2);
        String date3 = dtf2.format(now);
        System.out.println(date2);//2021年08月16日 12::57::59
        System.out.println(date3);//2021年08月16日 12::57::59
        System.out.println("-----------------------");

        //将字符串日期转回LocalDateTime
        LocalDateTime newDate = LocalDateTime.parse(date3, dtf2);
        System.out.println(newDate);//2021-08-16T12:57:59
    }

    @Test
    public void test7() {
        //获得所有时区
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        zoneIds.forEach(System.out::println);
    }

    @Test
    public void test8() {
        //指定时区的时间
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("US/Alaska"));
        System.out.println(ldt);//2021-08-15T21:08:46.406
        //指定时区的时间
        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));//2021-08-16T13:08:46.403
        //相差时区的时间
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Chile/Continental"));
        System.out.println(zdt);//2021-08-16T13:08:46.408-04:00[Chile/Continental]
    }
}