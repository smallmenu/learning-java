package com.niuchaoqun.example.advance;

import org.apache.commons.io.FileUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.IOException;

public class JsExample {
    private static String userDir = System.getProperties().getProperty("user.dir");
    private static String DS = File.separator;
    private static String dirPath = userDir + DS + "data";

    public static void run(String[] args) {
        js();
    }

    public static void js() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        File file = new File(dirPath + DS + "test.js");
        String jsCode = "";
        try {
            jsCode = FileUtils.readFileToString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            engine.eval(jsCode);
            if (engine instanceof Invocable) {
                Invocable in = (Invocable) engine;
                System.out.println(in.invokeFunction("relaod"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
