package com.niuchaoqun.example.jdk;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Date8Example {
    public static void run(String[] args) {
        date();
        format();
        function();
    }

    public static void date() {
        // 本地日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();
        System.out.println(localDate);
        System.out.println(localTime);

        System.out.println("----- date -----");
    }

    public static void format() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();

        // 格式化与解析
        String ymd1 = localDate.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        String ymd2 = now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒"));
        System.out.println(ymd1);
        System.out.println(ymd2);

        // 字符串解析
        String dt = "2017年04月07日 16时30分47秒";
        LocalDateTime pdt = LocalDateTime.parse(dt, DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒"));
        System.out.println(pdt);
        System.out.println(pdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // ISO标准格式可以直接解析
        String date1 = "2017-04-03";
        LocalDate parse1 = LocalDate.parse(date1);
        System.out.println(parse1);
        String date2 = "2017-04-03T06:18:56";
        LocalDateTime parse2 = LocalDateTime.parse(date2);
        System.out.println(parse2);
        System.out.println("====");

        // 获取时间戳，单位是毫秒
        long timestamp1 = Clock.systemDefaultZone().millis();
        long timestamp2 = System.currentTimeMillis();
        // 获取时间戳，单位是秒
        long timestamp3 = Instant.now().getEpochSecond();
        System.out.println(timestamp1);
        System.out.println(timestamp2);
        System.out.println(timestamp3);

        // 字符串与时间戳互转
        long timstamp_in = 1491582600;
        String format = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime local_in = LocalDateTime.ofEpochSecond(timstamp_in, 0, ZoneOffset.UTC);
        String timeString = local_in.format(DateTimeFormatter.ofPattern(format));
        System.out.println(timeString);

        LocalDateTime local_out = LocalDateTime.parse(timeString, DateTimeFormatter.ofPattern(format));
        long timstamp_out = local_out.toInstant(ZoneOffset.UTC).getEpochSecond();
        System.out.println(timstamp_out);

        System.out.println("----- format -----");
    }

    public static void function() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();

        // 日期时间操作
        System.out.println(now.plusDays(3));
        System.out.println(now.minusDays(3));
        System.out.println(now.with(TemporalAdjusters.lastDayOfYear()));
    }
}
