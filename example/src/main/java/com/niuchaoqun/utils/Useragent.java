package com.niuchaoqun.utils;

import java.util.Random;

public class Useragent {

    private static final Random random = new Random(System.currentTimeMillis());

    private static final String MOZILLA = "Mozilla/5.0 ";

    private static final String[][] OS = {
            {
                    "Windows NT 6.1",
                    "Windows NT 6.1; Win64; x64",
                    "Windows NT 6.2",
                    "Windows NT 6.2; Win64; x64",
                    "Windows NT 6.3",
                    "Windows NT 6.3; Win64; x64",
                    "Windows NT 6.4",
                    "Windows NT 6.4; Win64; x64",
                    "Windows NT 10",
                    "Windows NT 10; Win64; x64"
            },
            {
                    "Macintosh; Intel Mac OS X 10_12_1",
                    "Macintosh; Intel Mac OS X 10_12_2",
                    "Macintosh; Intel Mac OS X 10_12_3",
                    "Macintosh; Intel Mac OS X 10_12_4",
                    "Macintosh; Intel Mac OS X 10_12_5",
                    "Macintosh; Intel Mac OS X 10_13_2",
                    "Macintosh; Intel Mac OS X 10_13_3",
                    "Macintosh; Intel Mac OS X 10_13_4",
                    "Macintosh; Intel Mac OS X 10_13_5",
            }
    };

    private static final String[] CHROME_VERSION = {
            "51.0.2704.0",
            "52.0.2743.0",
            "53.0.2785.0",
            "54.0.2840.0",
            "55.0.2883.0",
            "56.0.2924.0",
            "57.0.2987.0",
            "58.0.3029.0",
            "59.0.3071.0",
            "60.0.3112.0",
            "61.0.3163.0",
            "62.0.3202.0",
            "63.0.3239.0",
            "64.0.3282.0",
            "65.0.3325.0",
            "66.0.3359.0",
            "67.0.3396.0"
    };

    private static final String[] FIREFOX_VERSION = {
            "51.0",
            "52.0",
            "53.0",
            "54.0",
            "55.0",
            "56.0",
            "57.0",
            "58.0",
            "59.0",
            "60.0",
            "61.0",
            "62.0",
    };

    private static final String[] IE_VERSION = {
            "8.0",
            "9.0",
            "10.0",
    };

    public static String all() {
        int r = random.nextInt(3);
        switch (r) {
            case 0:
                return chrome();
            case 1:
                return firefox();
            case 2:
                return ie();
            default:
                return chrome();
        }
    }

    public static String firefox() {
        String version = FIREFOX_VERSION[random.nextInt(FIREFOX_VERSION.length)];

        StringBuffer sb = new StringBuffer();
        sb.append(MOZILLA);
        sb.append("(");
        sb.append(randomStringArray(OS[random.nextInt(OS.length)]));
        sb.append("; rv:");
        sb.append(version);
        sb.append(")");
        sb.append(" Gecko/20121011 ");
        sb.append("Firefox/");
        sb.append(version);

        return sb.toString();
    }

    public static String chrome() {
        StringBuffer sb = new StringBuffer();
        sb.append(MOZILLA);
        sb.append("(");
        sb.append(randomStringArray((OS[random.nextInt(OS.length)])));
        sb.append(")");
        sb.append(" AppleWebKit/537.36 (KHTML, like Gecko) Chrome/");
        sb.append(CHROME_VERSION[random.nextInt(CHROME_VERSION.length)]);
        sb.append(" Safari/537.36");

        return sb.toString();
    }

    public static String ie() {
        String version = IE_VERSION[random.nextInt(IE_VERSION.length)];
        String trident = version.equals("10.0") ? "; Trident/6.0" : "; Trident/5.0";

        StringBuffer sb = new StringBuffer();
        sb.append(MOZILLA);
        sb.append("(");
        sb.append("compatible; MSIE ");
        sb.append(version);
        sb.append("; ");
        sb.append(randomStringArray((OS[0])));
        sb.append(trident);
        sb.append(")");

        return sb.toString();
    }

    private static String randomStringArray(String[] array) {
        int length = array.length;
        return array[random.nextInt(length)];
    }
}
