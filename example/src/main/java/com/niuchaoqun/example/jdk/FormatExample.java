package com.niuchaoqun.example.jdk;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class FormatExample {
    public static void run(String[] args) {
        numberFormat();
        decimalFormat();
    }

    public static void numberFormat() {
        NumberFormat nf = NumberFormat.getInstance();

        System.out.println(nf.format(123456789));
        System.out.println(nf.format(1234567.89));

        try {
            long l = (long)nf.parse("123,456,789");
            System.out.println(l);

            double d = (double)nf.parse("1,234,567.89");
            System.out.println(d);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("----- numberformat -----");
    }

    public static void decimalFormat() {
        System.out.println(new DecimalFormat("###,###.###").format(123456789.23456));

    }
}
