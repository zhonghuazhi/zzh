package com.boco.web.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zhonghua on 16/2/18.
 */
public class TestHelloServlet {



    public static void main(String[] args) {

//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String currentTime = dateFormat.format(new Date());
//        System.out.println("currentTime == " + currentTime);

        String fileName = "aaa.properties";
        loadProps(fileName);
    }

    public static Properties loadProps(String fileName) {

        Properties props = null;
        InputStream in = null;

        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (null == in) {
                throw new FileNotFoundException("file is not found. fileName = " + fileName);
            }

            props = new Properties();
            props.load(in);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return props;
    }

    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    public static String getString(Properties props, String key, String defaultValue) {

        String value = props.getProperty(key);
        return (null == value) ? defaultValue : value;
    }
}
