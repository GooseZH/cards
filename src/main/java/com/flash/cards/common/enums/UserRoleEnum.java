package com.flash.cards.common.enums;

import com.flash.cards.core.lang.BaseBeanConverter;
import com.flash.cards.core.lang.BaseBeanEnum;

/**
 * 用户角色枚举
 * @author lizheng
 * @since 2018/8/6 10:27
 **/
public enum UserRoleEnum implements BaseBeanEnum<Integer> {

    ADMIN   (3, "admin"),
    BUSINESS    (2, "business"),
    USER    (1, "user");

    private Integer code;
    private String msg;

    private UserRoleEnum(Integer code, String msg) {
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

    public static class Convert extends BaseBeanConverter<UserRoleEnum, Integer> {

    }
}
