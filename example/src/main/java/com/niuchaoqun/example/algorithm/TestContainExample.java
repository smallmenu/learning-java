package com.niuchaoqun.example.algorithm;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

public class TestContainExample {

    private static String userDir = System.getProperties().getProperty("user.dir");
    private static String DS = File.separator;
    private static String dirPath = userDir + DS + "data";

    public static void run(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test() throws IOException {
        String article = FileUtils.readFileToString(new File(dirPath + "/article.txt"));
        String dictString = FileUtils.readFileToString(new File(dirPath + "/dict.txt"));
        String[] dicts = dictString.split("\\n|\\r");


        article = article.replaceAll("[\\pP]|\\n|\\r", "");
        long start = System.currentTimeMillis();
        System.out.println(article);
        for (String dict : dicts) {
            //boolean contains = StringUtils.contains(article, dict);
            boolean contains = article.contains(dict);
            if (contains) {
                System.out.println(dict);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(article.length());
        System.out.println((end - start) + "ms");
    }
}
