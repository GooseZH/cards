package com.flash.cards.common.enums;

/**
 * @author lizheng
 * @since 2018/8/3 17:16
 **/
public enum ErrorCode {
    OK  (200, "OK"),
    ERROR   (500, "ERROR"),

    /**
     * 权限   参数  1000
     */
    PARAMS_ERROR    (1000,  "参数错误"),
    USER_USERNAME_NOT_FOUND (1001, "用户名不存在"),
    USER_PASSWORD_ERROR (1002,  "密码错误"),
    UN_LOGIN (1003,  "未登录"),
    USER_NOT_FOUND  (1004,  "用户未找到"),
    USER_STATUS_ERROR   (1005,  "用户状态异常");

    private Integer code;
    private String msg;
    private ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
