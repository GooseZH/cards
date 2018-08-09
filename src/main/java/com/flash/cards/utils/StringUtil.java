package com.flash.cards.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lizheng
 * @since 2018/8/3 16:27
 **/
public class StringUtil {

    /**
     * 分割字符串
     * @param str
     * @param separatorChars
     * @return
     */
    public static String[] split(String str, String separatorChars) {
        return StringUtils.split(str, separatorChars);
    }

    /**
     * 非空判断
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 非空判断
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
