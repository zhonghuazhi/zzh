package org.smart4j.chapter2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhonghua on 15/10/28.
 */
public final class CastUtil {

    /**
     * @param obj
     * @return
     */
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }

    /**
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castString(Object obj, String defaultValue) {
        return (null != obj) ? String.valueOf(obj) : defaultValue;
    }

    /**
     * @param obj
     * @return
     */
    public static Double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    /**
     * @param obj
     * @param defaultValue
     * @return
     */
    public static Double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (null != obj) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }
}
