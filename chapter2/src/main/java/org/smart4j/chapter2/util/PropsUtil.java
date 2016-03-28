package org.smart4j.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhonghua on 15/10/28.
 */
public final class PropsUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName) {

        Properties properties = null;
        InputStream inputStream = null;

        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (null == inputStream) {
                throw new FileNotFoundException(fileName + " file is not found.");
            }

            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("load properties file dailure .", e);
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("close inputStream failuer .", e);
                }
            }
        }
        return properties;
    }

    /**
     * @param props
     * @param key
     * @return
     */
    public static String getString(Properties props, String key) {

        return getString(props, key, "");
    }

    /**
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props, String key, String defaultValue) {

        String value = props.getProperty(key);
        return (null == value) ? defaultValue : value;
    }
}
