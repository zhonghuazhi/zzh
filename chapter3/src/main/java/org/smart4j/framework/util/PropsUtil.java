package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * 载入配置文件
     * @param fileName 配置文件名称
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
            logger.error("load properties file failure .", e);
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("close inputStream failure .", e);
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
