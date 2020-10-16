package com.gautam.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
    static Properties prop = new Properties();

    public static void loadProperties() {
        try {
            prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties")));
            prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\shopping.properties")));
            prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\output.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByKey(String key) {
        return prop.getProperty(key);
    }

    public static void updateProperty(String key, String value,String fileName) {
        try {
            FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\"+fileName);
            Properties props = new Properties();
            props.load(in);
            in.close();

            FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\"+fileName);
            props.setProperty(key, value);
            props.store(out, null);
            out.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
