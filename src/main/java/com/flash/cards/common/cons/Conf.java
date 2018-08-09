package com.flash.cards.common.cons;

/**
 * 常量类
 * @author lizheng
 * @since 2018/8/3 16:35
 **/
public class Conf {
    /**
     * 是否删除
     */
    public static class IS_DELETE {
        public static Integer OK = 0;
        public static Integer DEL = -1;
    }

    /**
     * 字符串常量
     */
    public static class STR {
        public static String IS_DELETE = "isDelete";
        public static String SESSIONID = "sessionId";
        public static String TOKEN = "token";
    }

    /**
     * 每页数量常量
     */
    public static class PAGE_SIZE {
        public static Integer DEFAULT_SIZE = 10;
    }
}
