package com.flash.cards.common.enums;

import com.flash.cards.core.lang.BaseBeanConverter;
import com.flash.cards.core.lang.BaseBeanEnum;

/**
 * 用户状态枚举
 * @author lizheng
 * @since 2018/8/8 10:42
 **/
public enum UserStatuEnum implements BaseBeanEnum<Integer> {
    OK  (0, "正常"),
    LOCK    (1, "锁定"),
    WAIT_FOR_VERIFICATION   (2, "待验证");

    private Integer code;
    private String msg;
    private UserStatuEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
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

    public static class Convert extends BaseBeanConverter<UserStatuEnum, Integer> {

    }
}
