package com.niuchaoqun.example.apache;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class CommonsIo {
    private static String url = "http://www.baidu.com";
    private static String userDir = System.getProperties().getProperty("user.dir");
    private static String DS = File.separator;
    private static String dirPath = userDir + DS + "data";

    public static void run(String[] args) {
        url();
        file();
        filename();
    }

    public static void url() {
        InputStream in = null;
        File file = new File(dirPath + DS + "baidu.html");
        try {
            in = new URL(url).openStream();
            System.out.println(IOUtils.toString(in));

            URL url = new URL(CommonsIo.url);

            FileUtils.copyURLToFile(url, file);

            System.out.println(FileUtils.sizeOf(file));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

    public static void file() {
        File file = new File(dirPath + DS + "common-io.txt");
        try {
            FileUtils.writeStringToFile(file, "abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void filename() {
        String filename = dirPath + DS + "common-io.txt";
        System.out.println(FilenameUtils.getExtension(filename));
        System.out.println(FilenameUtils.getFullPath(filename));
        System.out.println(FilenameUtils.getFullPathNoEndSeparator(filename));
        System.out.println(FilenameUtils.getName(filename));
        System.out.println(FilenameUtils.normalize(filename));
        System.out.println(FilenameUtils.separatorsToWindows(filename));
    }
}
